package com.example.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Checkin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CheckinMapper extends BaseMapper<Checkin> {
	
	Page<Checkin> getCheckinByCond (Page page , Integer checkinId , String customerId , Integer roomId , Integer empId , String status);
	
	int addCheckin (Checkin checkin);
	
}