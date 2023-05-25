package com.example.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Dining;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DiningMapper extends BaseMapper<Dining> {
	Page<Dining> getDiningByCond (Page page , Integer diningId , String customerId , Integer tableId , Integer empId , String status);
	
	int addDining (Dining dining);
	
	int updateDining (Dining dining);
	
	int selectId ();
}