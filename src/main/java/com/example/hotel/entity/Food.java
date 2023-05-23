package com.example.hotel.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Food {
	@TableId
	private Integer foodId;
	private String foodName;
	private Double price;
	private String image;
}