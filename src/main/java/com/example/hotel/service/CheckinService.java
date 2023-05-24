package com.example.hotel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Checkin;
import com.example.hotel.mapper.CheckinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckinService {
	@Autowired
	CheckinMapper checkinMapper;
	
	public Page<Checkin> getCheckinByCond (Page page , Integer checkinId , String customerId , Integer roomId , Integer empId , String status) {
		return checkinMapper.getCheckinByCond (page , checkinId , customerId , roomId , empId , status);
	}
	
	public int addCheckin (Checkin checkin) {
		return checkinMapper.addCheckin (checkin);
	}
}