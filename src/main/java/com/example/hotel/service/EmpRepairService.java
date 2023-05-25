package com.example.hotel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.EmpRepair;
import com.example.hotel.mapper.EmpRepairMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpRepairService {
	@Autowired
	EmpRepairMapper empRepairMapper;
	
	public Page<EmpRepair> getEmpRepairByCond (Page page , Integer empId , Integer roomId , Integer maintainEmpId , String repairStatus) {
		return empRepairMapper.getEmpRepairByCond (page , empId , roomId , maintainEmpId , repairStatus);
	}
	
	public int addEmpRepair (EmpRepair empRepair) {
		return empRepairMapper.addEmpRepair (empRepair);
	}
	
	public int updateEmpRepair (EmpRepair empRepair) {
		return empRepairMapper.updateEmpRepair (empRepair);
	}
}