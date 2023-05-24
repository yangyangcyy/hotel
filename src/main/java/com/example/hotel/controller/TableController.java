package com.example.hotel.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Table;
import com.example.hotel.response.Result;
import com.example.hotel.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/table")
public class TableController {
	@Autowired
	TableService tableService;
	
	@GetMapping ("/cond")
	public Result getTableByCond (@RequestParam (defaultValue = "-1") Integer current , @RequestParam (defaultValue = "-1") Integer size , Integer tableId , Integer minSeats , Integer maxSeats , String status) {
		Page page = new Page<> (current , size);
		Page<Table> tablePage = tableService.getTableByCond (page , tableId , minSeats , maxSeats , status);
		return Result.ok ().data ("items" , tablePage);
	}
	
	@PostMapping ("/add")
	public Result addTable (@RequestBody Table table) {
		if (tableService.addTable (table) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
	
	@PutMapping ("/update")
	public Result updateTable (@RequestBody Table table) {
		if (tableService.updateTable (table) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
	
	@DeleteMapping ("/deleteMul")
	public Result delMulTable (@RequestBody List<Integer> tableIds) {
		if (tableService.delMulTable (tableIds) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
}