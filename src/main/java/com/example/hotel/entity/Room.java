package com.example.hotel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Room {
	@TableId
	private Integer roomId;
	@TableField (exist = false)
	private RoomType roomType;
	private String image;
	private String status;
	private String remark;
}