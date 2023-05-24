package com.example.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.RoomReserve;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomReserveMapper extends BaseMapper<RoomReserve> {
	Page<RoomReserve> getRoomReserveByCond (Page page , Integer reserveId , String customerId , Integer roomId , String status);
	
	int addRoomReserve (RoomReserve roomReserve);
	
	int updateRoomReserve (RoomReserve roomReserve);
}