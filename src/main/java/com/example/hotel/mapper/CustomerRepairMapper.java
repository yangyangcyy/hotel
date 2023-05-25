package com.example.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.CustomerRepair;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerRepairMapper extends BaseMapper<CustomerRepair> {
	Page<CustomerRepair> getCustomerRepairByCond (Page page , String customerId , Integer roomId , Integer maintainEmpId , String repairStatus);
	
	int addCustomerRepair (CustomerRepair customerRepair);
	
	int updateCustomerRepair (CustomerRepair customerRepair);
}