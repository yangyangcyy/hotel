package com.example.hotel.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Checkout;
import com.example.hotel.response.Result;
import com.example.hotel.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/checkout")
public class CheckoutController {
	@Autowired
	CheckoutService checkoutService;
	
	@GetMapping ("/cond")
	public Result getRoomByCond (@RequestParam (defaultValue = "-1") Integer current , @RequestParam (defaultValue = "-1") Integer size , Integer checkinId , String customerId , Integer roomId , Integer empId) {
		Page page = new Page<> (current , size);
		Page<Checkout> checkoutPage = checkoutService.getCheckoutByCond (page , checkinId , customerId , roomId , empId);
		return Result.ok ().data ("items" , checkoutPage);
	}
	
	@PostMapping ("/add")
	public Result addCheckout (@RequestBody Checkout checkout) {
		if (checkoutService.addCheckout (checkout) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
	
	@PutMapping ("/update")
	public Result updateCheckout (@RequestBody Checkout checkout) {
		if (checkoutService.updateCheckout (checkout) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
}