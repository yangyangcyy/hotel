package com.example.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.ActualFood;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActualFoodMapper extends BaseMapper<ActualFood> {
	Page<ActualFood> getActualFoodByCond (Page page , Integer diningId , Integer foodId);
	
	Integer existsActualFood (ActualFood actualFood);
	
	int addMulActualFood (List<ActualFood> actualFoods);
	
	int updateMulActualFood (List<ActualFood> actualFoods);
}