package com.example.hotel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.RoomReserve;
import com.example.hotel.mapper.RoomReserveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomReserveService {
	@Autowired
	RoomReserveMapper roomReserveMapper;
	
	public Page<RoomReserve> getRoomReserveByCond (Page page , Integer reserveId , String customerId , Integer roomId , String status) {
		return roomReserveMapper.getRoomReserveByCond (page , reserveId , customerId , roomId , status);
	}
	
	public int addRoomReserve (RoomReserve roomReserve) {
		return roomReserveMapper.addRoomReserve (roomReserve);
	}
	
	public int updateRoomReserve (RoomReserve roomReserve) {
		return roomReserveMapper.updateRoomReserve (roomReserve);
	}
}