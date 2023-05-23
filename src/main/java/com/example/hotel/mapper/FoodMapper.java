package com.example.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodMapper extends BaseMapper<Food> {
	Page<Food> getFoodByCond (Page page , Integer foodId , String foodName);
	
	int addFood (Food food);
	
	int updateFood (Food food);
	
	int delMulFood (List<Integer> foodIds);
	
}