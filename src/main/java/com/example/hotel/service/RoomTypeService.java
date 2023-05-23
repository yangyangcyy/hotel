package com.example.hotel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.RoomType;
import com.example.hotel.mapper.RoomTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeService {
	@Autowired
	RoomTypeMapper roomTypeMapper;
	
	public Page<RoomType> getRoomTypeByCond (Page page , Integer roomTypeId , String roomTypeName) {
		return roomTypeMapper.getRoomTypeByCond (page , roomTypeId , roomTypeName);
	}
	
	public int addRoomType (RoomType roomType) {
		return roomTypeMapper.addRoomType (roomType);
	}
	
	public int updateRoomType (RoomType roomType) {
		return roomTypeMapper.updateRoomType (roomType);
	}
	
	public int delMulRoomType (List<Integer> roomTypeIds) {
		return roomTypeMapper.delMulRoomType (roomTypeIds);
	}
}