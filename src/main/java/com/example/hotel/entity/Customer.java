package com.example.hotel.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Customer {
	@TableId
	private String customerId;
	private String customerName;
	private String customerSex;
	private Integer customerAge;
	private String customerPhone;
	private String avatar;
	private String rank;
	private String password;
}