package com.example.hotel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class ReserveFood {
	@TableId (type = IdType.AUTO)
	private Integer id;
	@TableField (exist = false)
	private DiningReserve diningReserve;
	@TableField (exist = false)
	private Food food;
	private Integer quantity;
}