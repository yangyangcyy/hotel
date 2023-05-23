package com.example.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper extends BaseMapper<Dept> {
	
	Page<Dept> getDeptByCond (Page page , Integer deptId , String deptName);
	
	int addDept (Dept dept);
	
	int updateDept (Dept dept);
	
	int delMulDept (List<Integer> deptIds);
}