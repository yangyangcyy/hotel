package com.example.hotel.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.Util.UploadUtil;
import com.example.hotel.entity.Food;
import com.example.hotel.response.Result;
import com.example.hotel.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping ("/food")
public class FoodController {
	@Autowired
	FoodService foodService;
	
	@GetMapping ("/cond")
	public Result getFoodByCond (@RequestParam (defaultValue = "-1") Integer current , @RequestParam (defaultValue = "-1") Integer size , Integer foodId , String foodName) {
		Page page = new Page<> (current , size);
		Page<Food> foodPage = foodService.getFoodByCond (page , foodId , foodName);
		return Result.ok ().data ("items" , foodPage);
	}
	
	@PostMapping ("/add")
	public Result addFood (Food food , MultipartFile file) // MultipartFile实现文件上传
	{
		// 设置图片
		if (! Objects.isNull (file)) {
			String url = new UploadUtil ().uploadFile (file);
			food.setImage (url);
		}
		if (foodService.addFood (food) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
	
	@PutMapping ("/update")
	public Result updateFood (Food food , MultipartFile file) {
		// 设置头像
		if (! Objects.isNull (file)) {
			String url = new UploadUtil ().uploadFile (file);
			food.setImage (url);
			String oldFile = foodService.selectById (food.getFoodId ()).getImage ();
			UploadUtil.deleteFile (oldFile);
		}
		if (foodService.updateFood (food) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
	
	@DeleteMapping ("/deleteMul")
	public Result deleteMulFood (@RequestBody List<Integer> foodIds) {
		List<String> files = new ArrayList<> ();
		for (Integer id : foodIds) {
			files.add (foodService.selectById (id).getImage ());
		}
		foodService.delMulFood (foodIds);
		for (String file : files) {
			UploadUtil.deleteFile (file);
		}
		return Result.ok ();
	}
}