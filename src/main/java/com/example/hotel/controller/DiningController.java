package com.example.hotel.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.dto.DiningDto;
import com.example.hotel.entity.ActualFood;
import com.example.hotel.entity.Dining;
import com.example.hotel.response.Result;
import com.example.hotel.service.DiningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/dining")
public class DiningController {
	@Autowired
	DiningService diningService;
	
	@GetMapping ("/cond")
	public Result getDiningByCond (@RequestParam (defaultValue = "-1") Integer current , @RequestParam (defaultValue = "-1") Integer size , Integer diningId , String customerId , Integer tableId , Integer empId , String status) {
		Page page = new Page<> (current , size);
		Page<Dining> diningPage = diningService.getDiningByCond (page , diningId , customerId , tableId , empId , status);
		return Result.ok ().data ("items" , diningPage);
	}
	
	@GetMapping ("/food/cond")
	public Result getActualFoodByCond (@RequestParam (defaultValue = "-1") Integer current , @RequestParam (defaultValue = "-1") Integer size , Integer diningId , Integer foodId) {
		Page page = new Page<> (current , size);
		Page<ActualFood> actualFoodPage = diningService.getActualFoodByCond (page , diningId , foodId);
		return Result.ok ().data ("items" , actualFoodPage);
	}
	
	@PostMapping ("/dining")
	public Result dining (@RequestBody DiningDto diningDto) {
		diningService.dining (diningDto.getDining () , diningDto.getActualFoods ());
		return Result.ok ();
	}
	
	@PutMapping ("/food/update")
	public Result updateFood (@RequestBody List<ActualFood> actualFoods) {
		diningService.updateActualFood (actualFoods);
		return Result.ok ();
	}
	
	@PutMapping ("/update")
	public Result updateDining (@RequestBody Dining dining) {
		diningService.updateDining (dining);
		return Result.ok ();
	}
}