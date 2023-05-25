package com.example.hotel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.CustomerRepair;
import com.example.hotel.mapper.CustomerRepairMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerRepairService {
	@Autowired
	CustomerRepairMapper customerRepairMapper;
	
	public Page<CustomerRepair> getCustomerRepairByCond (Page page , String customerId , Integer roomId , Integer maintainEmpId , String repairStatus) {
		return customerRepairMapper.getCustomerRepairByCond (page , customerId , roomId , maintainEmpId , repairStatus);
	}
	
	public int addCustomerRepair (CustomerRepair customerRepair) {
		return customerRepairMapper.addCustomerRepair (customerRepair);
	}
	
	public int updateCustomerRepair (CustomerRepair customerRepair) {
		return customerRepairMapper.updateCustomerRepair (customerRepair);
	}
	
}