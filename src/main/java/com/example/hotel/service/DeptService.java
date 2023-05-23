package com.example.hotel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Dept;
import com.example.hotel.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {
	@Autowired
	DeptMapper deptMapper;
	
	public Page<Dept> getDeptByCond (Page page , Integer deptId , String deptName) {
		return deptMapper.getDeptByCond (page , deptId , deptName);
	}
	
	public int addDept (Dept dept) {
		return deptMapper.addDept (dept);
	}
	
	public int updateDept (Dept dept) {
		return deptMapper.updateDept (dept);
	}
	
	public int delMulDept (List<Integer> deptIds) {
		return deptMapper.delMulDept (deptIds);
	}
}