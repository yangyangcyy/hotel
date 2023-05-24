package com.example.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Checkout;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CheckoutMapper extends BaseMapper<Checkout> {
	Page<Checkout> getCheckoutByCond (Page page , Integer checkinId , String customerId , Integer roomId , Integer empId);
	
	int addCheckout (Checkout checkout);
	
	int updateCheckout (Checkout checkout);
}