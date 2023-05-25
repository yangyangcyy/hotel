package com.example.hotel.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.dto.DiningReserveDto;
import com.example.hotel.entity.DiningReserve;
import com.example.hotel.entity.ReserveFood;
import com.example.hotel.response.Result;
import com.example.hotel.service.DiningReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/diningReserve")
public class DiningReserveController {
	@Autowired
	DiningReserveService diningReserveService;
	
	@GetMapping ("/cond")
	public Result getDiningReserveByCond (@RequestParam (defaultValue = "-1") Integer current , @RequestParam (defaultValue = "-1") Integer size , Integer reserveId , String customerId , Integer tableId , String status) {
		Page page = new Page<> (current , size);
		Page<DiningReserve> diningReservePage = diningReserveService.getDiningReserveByCond (page , reserveId , customerId , tableId , status);
		return Result.ok ().data ("items" , diningReservePage);
	}
	
	@GetMapping ("/food/cond")
	public Result getReserveFoodByCond (@RequestParam (defaultValue = "-1") Integer current , @RequestParam (defaultValue = "-1") Integer size , Integer reserveId , Integer foodId) {
		Page page = new Page<> (current , size);
		Page<ReserveFood> reserveFoodPage = diningReserveService.getReserveFoodByCond (page , reserveId , foodId);
		return Result.ok ().data ("items" , reserveFoodPage);
	}
	
	@PostMapping ("/reserve")
	public Result diningReserve (@RequestBody DiningReserveDto diningReserveDto) {
		diningReserveService.diningReserve (diningReserveDto.getDiningReserve () , diningReserveDto.getReserveFoods ());
		return Result.ok ();
	}
	
	@PutMapping ("/food/update")
	public Result updateReserveFood (@RequestBody List<ReserveFood> reserveFoods) {
		diningReserveService.updateReserveFood (reserveFoods);
		return Result.ok ();
	}
	
	@PutMapping ("/update")
	public Result updateDiningReserve (@RequestBody DiningReserve diningReserve) {
		diningReserveService.updateDiningReserve (diningReserve);
		return Result.ok ();
	}
}