package com.example.hotel.mapper;

import com.example.hotel.entity.Finance;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface FinanceMapper {
	
	List<Finance> getFoodFinanceByCond (Date beginTime , Date endTime);
}