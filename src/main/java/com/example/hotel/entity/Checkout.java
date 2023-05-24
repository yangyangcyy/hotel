package com.example.hotel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Checkout {
	@TableId (type = IdType.AUTO)
	private String checkinId;
	@TableField (exist = false)
	private Customer customer;
	@TableField (exist = false)
	private Room room;
	@TableField (exist = false)
	private Emp emp;
	@JsonFormat (pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date checkinDate;
	@JsonFormat (pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date checkoutDate;
	@JsonFormat (pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date actualCheckoutDate;
	private Double roomRate;
	private String comment;
}