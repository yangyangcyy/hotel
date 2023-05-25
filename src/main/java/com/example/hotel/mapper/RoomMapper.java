package com.example.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper extends BaseMapper<Room> {
	Page<Room> getRoomByCond (Page page , Integer roomId , String roomTypeId , String status);
	
	int addRoom (Room room);
	
	int updateRoom (Room room);
	
	int delMulRoom (List<Integer> roomIds);
}