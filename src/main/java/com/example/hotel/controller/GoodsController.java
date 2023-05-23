package com.example.hotel.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Goods;
import com.example.hotel.response.Result;
import com.example.hotel.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/goods")
public class GoodsController {
	@Autowired
	GoodsService goodsService;
	
	@GetMapping ("/cond")
	public Result getGoodsByCond (@RequestParam (defaultValue = "-1") Integer current , @RequestParam (defaultValue = "-1") Integer size , Integer goodsId , String goodsName) {
		Page page = new Page<> (current , size);
		Page<Goods> goodsPage = goodsService.getGoodsByCond (page , goodsId , goodsName);
		return Result.ok ().data ("items" , goodsPage);
	}
	
	@PostMapping ("/add")
	public Result addGoods (Goods goods) {
		if (goodsService.addGoods (goods) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
	
	@PutMapping ("/update")
	public Result updateGoods (Goods goods) {
		if (goodsService.updateGoods (goods) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
	
	@DeleteMapping ("/deleteMul")
	public Result delMulGoods (@RequestBody List<Integer> goodsIds) {
		if (goodsService.delMulGoods (goodsIds) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
}