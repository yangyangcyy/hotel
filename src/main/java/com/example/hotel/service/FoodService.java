package com.example.hotel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Food;
import com.example.hotel.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
	@Autowired
	FoodMapper foodMapper;
	
	public Page<Food> getFoodByCond (Page page , Integer foodId , String foodName) {
		return foodMapper.getFoodByCond (page , foodId , foodName);
	}
	
	public int addFood (Food food) {
		return foodMapper.addFood (food);
	}
	
	public int updateFood (Food food) {
		return foodMapper.updateFood (food);
	}
	
	public int delMulFood (List<Integer> foodIds) {
		return foodMapper.delMulFood (foodIds);
	}
	
	public Food selectById (Integer foodId) {
		return foodMapper.selectById (foodId);
	}
}