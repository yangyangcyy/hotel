package com.example.hotel.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class RoomReserve {
	@TableId (type = IdType.AUTO)
	private Integer reserveId;
	@TableField (exist = false)
	private Customer customer;
	@TableField (exist = false)
	private Room room;
	@JsonFormat (pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField (format = "yyyy-MM-dd HH:mm:ss")
	private Date orderTime;
	@JsonFormat (pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@JSONField (format = "yyyy-MM-dd")
	private Date reserveCheckinDate;
	@JsonFormat (pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@JSONField (format = "yyyy-MM-dd")
	private Date reserveCheckoutDate;
	private Double roomRate;
	private String status;
}