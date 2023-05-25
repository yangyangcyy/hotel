package com.example.hotel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Dining {
	@TableId (type = IdType.AUTO)
	private Integer diningId;
	@TableField (exist = false)
	private Customer customer;
	@TableField (exist = false)
	private Table table;
	@TableField (exist = false)
	private Emp emp;
	private Date diningTime;
	private Double price;
	private String status;
	private String comment;
}