package com.example.hotel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Room;
import com.example.hotel.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
	@Autowired
	RoomMapper roomMapper;
	
	public Page<Room> getRoomByCond (Page page , Integer roomId , String roomTypeId , String roomTypeName , String roomStatus) {
		return roomMapper.getRoomByCond (page , roomId , roomTypeId , roomTypeName , roomStatus);
	}
	
	public int addRoom (Room room) {
		return roomMapper.addRoom (room);
	}
	
	public int updateRoom (Room room) {
		return roomMapper.updateRoom (room);
	}
	
	public int delMulRoom (List<Integer> roomIds) {
		return roomMapper.delMulRoom (roomIds);
	}
	
	public Room selectById (Integer roomId) {
		return roomMapper.selectById (roomId);
	}
}