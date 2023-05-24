package com.example.hotel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Dept {
	@TableId (type = IdType.AUTO)
	private Integer deptId;
	private String deptName;
	@TableField (exist = false)
	private Integer empNums;
}