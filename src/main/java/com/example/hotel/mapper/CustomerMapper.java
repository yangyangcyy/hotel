package com.example.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
	Page<Customer> getCustomerByCond (Page page , String customerId , String customerName , String rank);
	
	int addCustomer (Customer customer);
	
	int updateCustomer (Customer customer);
	
	int delMulCustomer (List<String> customerIds);
}