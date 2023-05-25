package com.example.hotel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;


@Data
public class Service {
	@TableId (type = IdType.AUTO)
	private Integer serviceId;
	@TableField (exist = false)
	private Emp emp;
	@TableField (exist = false)
	private Customer customer;
	@TableField (exist = false)
	private String serviceContent;
	private Date applicationTime;
	private Date startTime;
	private Date endTime;
	private String status;
}