package com.example.hotel.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Checkin;
import com.example.hotel.response.Result;
import com.example.hotel.service.CheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/checkin")
public class CheckinController {
	@Autowired
	CheckinService checkinService;
	
	@GetMapping ("/cond")
	public Result getRoomByCond (@RequestParam (defaultValue = "-1") Integer current , @RequestParam (defaultValue = "-1") Integer size , Integer checkinId , String customerId , Integer roomId , Integer empId , String status) {
		Page page = new Page<> (current , size);
		Page<Checkin> checkinPage = checkinService.getCheckinByCond (page , checkinId , customerId , roomId , empId , status);
		return Result.ok ().data ("items" , checkinPage);
	}
	
	@PostMapping ("/add")
	public Result addCheckin (@RequestBody Checkin checkin) {
		if (checkinService.addCheckin (checkin) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
}