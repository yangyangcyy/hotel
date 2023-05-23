package com.example.hotel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class RoomType {
	@TableId
	private Integer roomTypeId;
	private String roomTypeName;
	private Integer residentNums;
	private Integer bedNums;
	private Double price;
	@TableField (exist = false)
	private Integer roomNums;
}