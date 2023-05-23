package com.example.hotel.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.Util.UploadUtil;
import com.example.hotel.entity.Emp;
import com.example.hotel.response.Result;
import com.example.hotel.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping ("/emp")
public class EmpController {
	@Autowired
	EmpService empService;
	
	@GetMapping ("/cond")
	public Result getEmpByCond (@RequestParam (defaultValue = "-1") Integer current , @RequestParam (defaultValue = "-1") Integer size , Integer empId , String empName , Integer deptId , String deptName , String isAdmin) {
		Page page = new Page<> (current , size);
		Page<Emp> empPage = empService.getEmpByCond (page , empId , empName , deptId , deptName , isAdmin);
		return Result.ok ().data ("items" , empPage);
	}
	
	@PostMapping ("/add")
	public Result addEmp (Emp emp , MultipartFile file) // MultipartFile实现文件上传
	{
		// 设置头像
		if (! Objects.isNull (file)) {
			String url = new UploadUtil ().uploadFile (file);
			emp.setAvatar (url);
		}
		if (empService.addEmp (emp) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
	
	@PutMapping ("/update")
	public Result updateEmp (Emp emp , MultipartFile file) {
		// 设置头像
		if (! Objects.isNull (file)) {
			String url = new UploadUtil ().uploadFile (file);
			emp.setAvatar (url);
			String oldFile = empService.selectById (emp.getEmpId ()).getAvatar ();
			UploadUtil.deleteFile (oldFile);
		}
		if (empService.updateEmp (emp) > 0) {
			return Result.ok ();
		}
		return Result.error ();
	}
	
	@DeleteMapping ("/deleteMul")
	public Result deleteMulCustoemr (@RequestBody List<Integer> empIds) {
		List<String> files = new ArrayList<> ();
		for (Integer id : empIds) {
			files.add (empService.selectById (id).getAvatar ());
		}
		empService.delMulEmp (empIds);
		for (String file : files) {
			UploadUtil.deleteFile (file);
		}
		return Result.ok ();
	}
}