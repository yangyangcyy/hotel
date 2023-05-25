package com.example.hotel.controller;

import com.example.hotel.entity.Finance;
import com.example.hotel.response.Result;
import com.example.hotel.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping ("/finance")
public class FinanceController {
	@Autowired
	FinanceService financeService;
	
	@GetMapping ("/food")
	public Result getFoodFinanceByCond (Date beginTime , Date endTime) {
		return Result.ok ().data ("items" , financeService.getFoodFinanceByCond (beginTime , endTime));
	}
	
	@GetMapping ("/all")
	public Result getAllFinanceByCond (Date beginTime , Date endTime) {
		List<Finance> foodFinance = financeService.getFoodFinanceByCond (beginTime , endTime);
		return Result.ok ().data ("food" , foodFinance);
	}
}