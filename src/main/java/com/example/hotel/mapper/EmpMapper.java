package com.example.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper extends BaseMapper<Emp> {
	
	Page<Emp> getEmpByCond (Page page , Integer empId , String empName , Integer deptId , String isAdmin);
	
	int addEmp (Emp emp);
	
	int updateEmp (Emp emp);
	
	int delMulEmp (List<Integer> empIds);
	
	int updateAvatar (Integer empId , String avatar);
	
	int updatePwd (Integer empId , String oldpwd , String newpwd);
	
}