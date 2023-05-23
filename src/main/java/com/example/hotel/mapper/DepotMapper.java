package com.example.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Depot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepotMapper extends BaseMapper<Depot> {
	Page<Depot> getDepotByCond (Page page , Integer depotId , String depotAddress);
	
	int addDepot (Depot depot);
	
	int updateDepot (Depot depot);
	
	int delMulDepot (List<Integer> depotIds);
}