package com.example.hotel.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.Util.UploadUtil;
import com.example.hotel.entity.Customer;
import com.example.hotel.response.Result;
import com.example.hotel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping ("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping ("/cond")
	public Result getCustomerByCond (@RequestParam (defaultValue = "-1") Integer current , @RequestParam (defaultValue = "-1") Integer size , String customerId , String customerName , String rank) {
		Page page = new Page<> (current , size);
		Page<Customer> customerPage = customerService.getCustomerByCond (page , customerId , customerName , rank);
		return Result.ok ().data ("items" , customerPage);
	}
	
	@PostMapping ("/add")
	public Result addCustomer (Customer customer , MultipartFile file) // MultipartFile实现文件上传
	{
		// 设置头像
		if (! Objects.isNull (file)) {
			String url = new UploadUtil ().uploadFile (file);
			customer.setAvatar (url);
		}
		if (customerService.addCustomer (customer) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
	
	@PutMapping ("/update")
	public Result updateCustomer (Customer customer , MultipartFile file) {
		// 设置头像
		if (! Objects.isNull (file)) {
			String url = new UploadUtil ().uploadFile (file);
			customer.setAvatar (url);
			String oldFile = customerService.selectById (customer.getCustomerId ()).getAvatar ();
			UploadUtil.deleteFile (oldFile);
		}
		if (customerService.updateCustomer (customer) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
	
	@DeleteMapping ("/deleteMul")
	public Result deleteMulCustoemr (@RequestBody List<String> customerIds) {
		List<String> files = new ArrayList<> ();
		for (String id : customerIds) {
			files.add (customerService.selectById (id).getAvatar ());
		}
		if (customerService.delMulCustomer (customerIds) > 0) {
			for (String file : files) {
				UploadUtil.deleteFile (file);
			}
			return Result.ok ();
		}
		return Result.error ();
	}
}