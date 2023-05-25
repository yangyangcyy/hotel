package com.example.hotel.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.EmpRepair;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpRepairMapper {
	Page<EmpRepair> getEmpRepairByCond (Page page , Integer empId , Integer roomId , Integer maintainEmpId , String repairStatus);
	
	int addEmpRepair (EmpRepair empRepair);
	
	int updateEmpRepair (EmpRepair empRepair);
}