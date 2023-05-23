package com.example.hotel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Emp;
import com.example.hotel.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
	@Autowired
	EmpMapper empMapper;
	
	public Page<Emp> getEmpByCond (Page page , Integer empId , String empName , Integer deptId , String deptName , String isAdmin) {
		return empMapper.getEmpByCond (page , empId , empName , deptId , deptName , isAdmin);
	}
	
	public int addEmp (Emp emp) {
		return empMapper.addEmp (emp);
	}
	
	public int updateEmp (Emp emp) {
		return empMapper.updateEmp (emp);
	}
	
	public int delMulEmp (List<Integer> empIds) {
		return empMapper.delMulEmp (empIds);
	}
	
	public Emp selectById (Integer empId) {
		return empMapper.selectById (empId);
	}
}