package com.example.hotel.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Depot {
	@TableId
	private Integer depotId;
	private String depotAddress;
}