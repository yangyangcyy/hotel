package com.example.hotel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Goods {
	@TableId
	private Integer goodsId;
	private String goodsName;
	@TableField (exist = false)
	private Integer inventory;
}