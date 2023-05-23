package com.example.hotel.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Table {
	@TableId
	private Integer tableId;
	private Integer seats;
	private String status;
}