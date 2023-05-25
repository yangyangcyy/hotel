package com.example.hotel.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.CustomerRepair;
import com.example.hotel.response.Result;
import com.example.hotel.service.CustomerRepairService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/customerRepair")
public class CustomerRepairController {
	CustomerRepairService customerRepairService;
	
	@GetMapping ("/cond")
	public Result getCustomerRepairByCond (@RequestParam (defaultValue = "-1") Integer current , @RequestParam (defaultValue = "-1") Integer size , String customerId , Integer roomId , Integer maintainEmpId , String repairStatus) {
		Page page = new Page<> (current , size);
		Page<CustomerRepair> customerRepairPage =
				customerRepairService.getCustomerRepairByCond (page , customerId , roomId , maintainEmpId , repairStatus);
		return Result.ok ().data ("items" , customerRepairPage);
	}
	
	@PostMapping ("/add")
	public Result addCustomerRepair (@RequestBody CustomerRepair customerRepair) {
		customerRepairService.addCustomerRepair (customerRepair);
		return Result.ok ();
	}
	
	@PutMapping ("/update")
	public Result updateCustomerRepair (CustomerRepair customerRepair) {
		customerRepairService.updateCustomerRepair (customerRepair);
		return Result.ok ();
	}
}