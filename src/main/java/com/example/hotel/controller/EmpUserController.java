package com.example.hotel.controller;

import com.example.hotel.Util.JWTUtils;
import com.example.hotel.Util.UploadUtil;
import com.example.hotel.entity.Emp;
import com.example.hotel.entity.EmpUser;
import com.example.hotel.response.Result;
import com.example.hotel.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping ("/empUser")
public class EmpUserController {
	@Autowired
	EmpService empService;
	
	@PostMapping ("/login")
	public Result login (@RequestBody EmpUser empUser) {
		Emp emp = empService.selectById (empUser.getEmpId ());
		if (! Objects.isNull (emp) && emp.getPassword ().equals (empUser.getPassword ())) {
			String token = JWTUtils.generateToken (empUser.getEmpId ());
			return Result.ok ().data ("token" , token);
		}
		return Result.error ();
	}
	
	@GetMapping ("/info")
	public Result info (String token) {
		String empId = JWTUtils.getClaimsByToken (token).getSubject ();
		Emp emp = empService.selectById (Integer.parseInt (empId));
		String avatar = emp.getAvatar ();
		String isAdmin = emp.getIsAdmin ();
		List roles = new ArrayList<> ();
		if (isAdmin.equals ("是")) {
			roles.add ("admin");
		}
		else {
			roles.add ("non-admin");
		}
		return Result.ok ().data ("empId" , empId).data ("avatar" , avatar).data ("roles" , roles);
	}
	
	@PostMapping ("/logout")
	public Result logout () {
		return Result.ok ();
	}
	
	@PutMapping ("/updateAvatar")
	public Result updateAvatar (Integer empId , MultipartFile file) {
		// 设置头像
		String url = UploadUtil.uploadFile (file);
		empService.updateAvatar (empId , url);
		String oldFile = empService.selectById (empId).getAvatar ();
		UploadUtil.deleteFile (oldFile);
		return Result.ok ();
	}
	
	@PutMapping ("/updatePwd")
	public Result updatePwd (Integer empId , String oldpwd , String newpwd) {
		String pwd = empService.selectById (empId).getPassword ();
		if (pwd.equals (oldpwd)) {
			empService.updatePwd (empId , oldpwd , newpwd);
			return Result.ok ();
		}
		return Result.error ();
	}
}