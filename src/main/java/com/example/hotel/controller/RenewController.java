package com.example.hotel.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Renew;
import com.example.hotel.response.Result;
import com.example.hotel.service.RenewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/renew")
public class RenewController {
	@Autowired
	RenewService renewService;
	
	@GetMapping ("/cond")
	public Result getRoomByCond (@RequestParam (defaultValue = "-1") Integer current , @RequestParam (defaultValue = "-1") Integer size , Integer checkinId) {
		Page page = new Page<> (current , size);
		Page<Renew> renewPage = renewService.getRenewByCond (page , checkinId);
		return Result.ok ().data ("items" , renewPage);
	}
	
	@PostMapping ("/add")
	public Result addRenew (@RequestBody Renew renew) {
		if (renewService.addRenew (renew) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
}