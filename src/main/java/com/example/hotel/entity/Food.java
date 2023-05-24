package com.example.hotel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Food {
	@TableId (type = IdType.AUTO)
	private Integer foodId;
	private String foodName;
	private Double price;
	private String image;
}