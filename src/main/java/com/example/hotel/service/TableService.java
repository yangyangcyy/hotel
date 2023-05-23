package com.example.hotel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Table;
import com.example.hotel.mapper.TableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {
	@Autowired
	TableMapper tableMapper;
	
	public Page<Table> getTableByCond (Page page , Integer tableId , Integer minSeats , Integer maxSeats , String status) {
		return tableMapper.getTableByCond (page , tableId , minSeats , maxSeats , status);
	}
	
	public int addTable (Table table) {
		return tableMapper.addTable (table);
	}
	
	public int updateTable (Table table) {
		return tableMapper.updateTable (table);
	}
	
	public int delMulTable (List<Integer> tableIds) {
		return tableMapper.delMulTable (tableIds);
	}
}