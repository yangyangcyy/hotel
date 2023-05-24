package com.example.hotel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Emp {
	@TableId (type = IdType.AUTO)
	private Integer empId;
	private String empName;
	private String empSex;
	private Integer empAge;
	private String empPhone;
	@TableField (exist = false)
	private Dept dept;
	private Double salary;
	private String avatar;
	private String password;
	private String isAdmin;
}