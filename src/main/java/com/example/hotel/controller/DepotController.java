package com.example.hotel.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Depot;
import com.example.hotel.response.Result;
import com.example.hotel.service.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/depot")
public class DepotController {
	@Autowired
	DepotService depotService;
	
	@GetMapping ("/cond")
	public Result getDepotByCond (@RequestParam (defaultValue = "-1") Integer current , @RequestParam (defaultValue = "-1") Integer size , Integer depotId , String depotAddress) {
		Page page = new Page<> (current , size);
		Page<Depot> depotPage = depotService.getDepotByCond (page , depotId , depotAddress);
		return Result.ok ().data ("items" , depotPage);
	}
	
	@PostMapping ("/add")
	public Result addDepot (Depot depot) {
		if (depotService.addDepot (depot) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
	
	@PutMapping ("/update")
	public Result updateDepot (Depot depot) {
		if (depotService.updateDepot (depot) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
	
	@DeleteMapping ("/deleteMul")
	public Result delMulDepot (@RequestBody List<Integer> depotIds) {
		if (depotService.delMulDepot (depotIds) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
}