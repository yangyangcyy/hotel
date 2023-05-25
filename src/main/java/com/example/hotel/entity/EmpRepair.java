package com.example.hotel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class EmpRepair {
	@TableId (type = IdType.AUTO)
	private Integer repairId;
	@TableField (exist = false)
	private Emp emp;
	@TableField (exist = false)
	private Room room;
	private String repairContent;
	private Date repairTime;
	@TableField (exist = false)
	private Emp maintainEmp;
	private Date startTime;
	private Date endTime;
	private Double repariCost;
	private String repairStatus;
}