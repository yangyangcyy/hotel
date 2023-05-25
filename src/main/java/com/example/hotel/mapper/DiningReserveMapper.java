package com.example.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.DiningReserve;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DiningReserveMapper extends BaseMapper<DiningReserve> {
	Page<DiningReserve> getDiningReserveByCond (Page page , Integer reserveId , String customerId , Integer tableId , String status);
	
	int addDiningReserve (DiningReserve diningReserve);
	
	int updateDiningReserve (DiningReserve diningReserve);
	
	int selectId ();
}