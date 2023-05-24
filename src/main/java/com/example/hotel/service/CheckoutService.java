package com.example.hotel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Checkout;
import com.example.hotel.mapper.CheckoutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {
	@Autowired
	CheckoutMapper checkoutMapper;
	
	public Page<Checkout> getCheckoutByCond (Page page , Integer checkinId , String customerId , Integer roomId , Integer empId) {
		return checkoutMapper.getCheckoutByCond (page , checkinId , customerId , roomId , empId);
	}
	
	public int addCheckout (Checkout checkout) {
		return checkoutMapper.addCheckout (checkout);
	}
	
	public int updateCheckout (Checkout checkout) {
		return checkoutMapper.updateCheckout (checkout);
	}
}