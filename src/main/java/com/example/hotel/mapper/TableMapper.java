package com.example.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Table;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TableMapper extends BaseMapper<Table> {
	Page<Table> getTableByCond (Page page , Integer tableId , Integer minSeats , Integer maxSeats , String status);
	
	int addTable (Table table);
	
	int updateTable (Table table);
	
	int delMulTable (List<Integer> tableIds);
}