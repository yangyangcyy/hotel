package com.example.hotel.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.RoomReserve;
import com.example.hotel.response.Result;
import com.example.hotel.service.RoomReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/roomReserve")
public class RoomReserveController {
	@Autowired
	RoomReserveService roomReserveService;
	
	@GetMapping ("/cond")
	public Result getRoomByCond (@RequestParam (defaultValue = "-1") Integer current , @RequestParam (defaultValue = "-1") Integer size , Integer reserveId , String customerId , Integer roomId , String status) {
		Page page = new Page<> (current , size);
		Page<RoomReserve> roomReservePage = roomReserveService.getRoomReserveByCond (page , reserveId , customerId , roomId , status);
		return Result.ok ().data ("items" , roomReservePage);
	}
	
	@PostMapping ("/add")
	public Result addRoomReserve (@RequestBody RoomReserve roomReserve) {
		if (roomReserveService.addRoomReserve (roomReserve) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
	
	@PutMapping ("/update")
	public Result updateRoomReserve (@RequestBody RoomReserve roomReserve) {
		if (roomReserveService.updateRoomReserve (roomReserve) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
}