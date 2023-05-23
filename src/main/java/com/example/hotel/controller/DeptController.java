package com.example.hotel.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Dept;
import com.example.hotel.response.Result;
import com.example.hotel.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/dept")
public class DeptController {
	@Autowired
	DeptService deptService;
	
	@GetMapping ("/cond")
	public Result getDeptByCond (@RequestParam (defaultValue = "-1") Integer current , @RequestParam (defaultValue = "-1") Integer size , Integer deptId , String deptName) {
		Page page = new Page<> (current , size);
		Page<Dept> deptPage = deptService.getDeptByCond (page , deptId , deptName);
		return Result.ok ().data ("items" , deptPage);
	}
	
	@PostMapping ("/add")
	public Result addDept (Dept dept) {
		if (deptService.addDept (dept) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
	
	@PutMapping ("/update")
	public Result updateDept (Dept dept) {
		if (deptService.updateDept (dept) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
	
	@DeleteMapping ("/deleteMul")
	public Result delMulDept (@RequestBody List<Integer> deptIds) {
		if (deptService.delMulDept (deptIds) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
}