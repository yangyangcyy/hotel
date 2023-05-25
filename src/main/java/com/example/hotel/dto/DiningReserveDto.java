package com.example.hotel.dto;

import com.example.hotel.entity.DiningReserve;
import com.example.hotel.entity.ReserveFood;
import lombok.Data;

import java.util.List;

@Data
public class DiningReserveDto {
	private DiningReserve diningReserve;
	private List<ReserveFood> reserveFoods;
}