package com.example.hotel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/empUser")
public class EmpUserController {
//	@Autowired
//	EmpService empService;
//
//	@PostMapping ("/login")
//	public Result login (@RequestBody User user) {
//		Emp emp = empService.selectEmpById (user.getEmpId ());
//		if (! Objects.isNull (emp) && emp.getPassword ().equals (user.getPassword ())) {
//			String token = JWTUtils.generateToken (user.getEmpId ());
//			return Result.ok ().data ("token" , token);
//		}
//		return Result.error ();
//	}
//
//	@GetMapping ("/info")
//	public Result info (String token) {
//		String empId = JWTUtils.getClaimsByToken (token).getSubject ();
//		Emp emp = empService.selectEmpById (Integer.parseInt (empId));
//		String avatar = emp.getAvatar ();
//		String isAdmin = emp.getIsAdmin ();
//		List roles = new ArrayList<> ();
//		if (isAdmin.equals ("是")) {
//			roles.add ("admin");
//		}
//		else {
//			roles.add ("non-admin");
//		}
//		return Result.ok ().data ("empId" , empId).data ("avatar" , avatar).data ("roles" , roles);
//	}
//
//	@PostMapping ("/logout")
//	public Result logout () {
//		return Result.ok ();
//	}
//
//	@PutMapping ("/updateAvatar")
//	public Result updateAvatar (Integer empId , MultipartFile file) {
//		// 设置头像
//		String url = UploadUtil.uploadFile (file);
//		empService.updateAvatar (empId , url);
//		return Result.ok ();
//	}
//
//	@PutMapping ("/updatePwd")
//	public Result updatePwd (Integer empId , String oldpwd , String newpwd) {
//		String pwd = empService.selectEmpById (empId).getPassword ();
//		if (pwd.equals (oldpwd)) {
//			empService.updatePwd (empId , oldpwd , newpwd);
//			return Result.ok ();
//		}
//		return Result.error ();
//	}
}