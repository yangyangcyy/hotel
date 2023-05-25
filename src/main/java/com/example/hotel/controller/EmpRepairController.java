package com.example.hotel.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.EmpRepair;
import com.example.hotel.response.Result;
import com.example.hotel.service.EmpRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/empRepair")
public class EmpRepairController {
	@Autowired
	EmpRepairService empRepairService;
	
	@GetMapping ("/cond")
	public Result getEmpRepairByCond (@RequestParam (defaultValue = "-1") Integer current , @RequestParam (defaultValue = "-1") Integer size , Integer empId , Integer roomId , Integer maintainEmpId , String repairStatus) {
		Page page = new Page<> (current , size);
		Page<EmpRepair> empRepairPage =
				empRepairService.getEmpRepairByCond (page , empId , roomId , maintainEmpId , repairStatus);
		return Result.ok ().data ("items" , empRepairPage);
	}
	
	@PostMapping ("/add")
	public Result addEmpRepair (@RequestBody EmpRepair empRepair) {
		empRepairService.addEmpRepair (empRepair);
		return Result.ok ();
	}
	
	@PutMapping ("/update")
	public Result updateEmpRepair (EmpRepair empRepair) {
		empRepairService.updateEmpRepair (empRepair);
		return Result.ok ();
	}
}