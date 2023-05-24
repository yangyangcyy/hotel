package com.example.hotel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName ("diningTable")
public class Table {
	@TableId (type = IdType.AUTO)
	private Integer tableId;
	private Integer seats;
	private String status;
}