package com.example.hotel.dto;

import com.example.hotel.entity.ActualFood;
import com.example.hotel.entity.Dining;
import lombok.Data;

import java.util.List;

@Data
public class DiningDto {
	private Dining dining;
	private List<ActualFood> actualFoods;
}