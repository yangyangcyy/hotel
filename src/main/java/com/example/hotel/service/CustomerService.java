package com.example.hotel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Customer;
import com.example.hotel.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
	@Autowired
	CustomerMapper customerMapper;
	
	public Page<Customer> getCustomerByCond (Page page , String customerId , String customerName , String rank) {
		return customerMapper.getCustomerByCond (page , customerId , customerName , rank);
	}
	
	public int addCustomer (Customer customer) {
		return customerMapper.addCustomer (customer);
	}
	
	public int updateCustomer (Customer customer) {
		return customerMapper.updateCustomer (customer);
	}
	
	public int delMulCustomer (List<String> customerIds) {
		return customerMapper.delMulCustomer (customerIds);
	}
	
	public Customer selectById (String customerId) {
		return customerMapper.selectById (customerId);
	}
}