package com.example.hotel.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Finance {
	@JsonFormat (pattern = "yyyy-MM", timezone = "GMT+8")
	private Date time;
	private Double money;
}