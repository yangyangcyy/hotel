package com.example.hotel.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.RoomType;
import com.example.hotel.response.Result;
import com.example.hotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/roomType")
public class RoomTypeController {
	@Autowired
	RoomTypeService roomTypeService;
	
	@GetMapping ("/cond")
	public Result getRoomTypeByCond (@RequestParam (defaultValue = "-1") Integer current , @RequestParam (defaultValue = "-1") Integer size , Integer roomTypeId , String roomTypeName) {
		Page page = new Page<> (current , size);
		Page<RoomType> roomTypePage = roomTypeService.getRoomTypeByCond (page , roomTypeId , roomTypeName);
		return Result.ok ().data ("items" , roomTypePage);
	}
	
	@PostMapping ("/add")
	public Result addRoomType (@RequestBody RoomType roomType) {
		if (roomTypeService.addRoomType (roomType) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
	
	@PutMapping ("/update")
	public Result updateRoomType (@RequestBody RoomType roomType) {
		if (roomTypeService.updateRoomType (roomType) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
	
	@DeleteMapping ("/deleteMul")
	public Result delMulRoomType (@RequestBody List<Integer> roomTypeIds) {
		if (roomTypeService.delMulRoomType (roomTypeIds) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
}