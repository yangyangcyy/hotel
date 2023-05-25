package com.example.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.ReserveFood;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReserveFoodMapper extends BaseMapper<ReserveFood> {
	Page<ReserveFood> getReserveFoodByCond (Page page , Integer reserveId , Integer foodId);
	
	Integer existsReserveFood (ReserveFood reserveFood);
	
	int addMulReserveFood (List<ReserveFood> reserveFoods);
	
	int updateMulReserveFood (List<ReserveFood> reserveFoods);
}