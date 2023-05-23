package com.example.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.RoomType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomTypeMapper extends BaseMapper<RoomType> {
	Page<RoomType> getRoomTypeByCond (Page page , Integer roomTypeId , String roomTypeName);
	
	int addRoomType (RoomType roomType);
	
	int updateRoomType (RoomType roomType);
	
	int delMulRoomType (List<Integer> roomTypeIds);
}