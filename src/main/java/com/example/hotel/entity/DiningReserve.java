package com.example.hotel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class
DiningReserve {
	@TableId (type = IdType.AUTO)
	private Integer reserveId;
	@TableField (exist = false)
	private Customer customer;
	@TableField (exist = false)
	private Table table;
	private Date orderTime;
	private Date reserveDiningTime;
	private Double price;
	private String status;
}