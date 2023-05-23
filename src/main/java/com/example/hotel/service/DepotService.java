package com.example.hotel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Depot;
import com.example.hotel.mapper.DepotMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepotService {
	@Autowired
	DepotMapper depotMapper;
	
	public Page<Depot> getDepotByCond (Page page , Integer depotId , String depotAddress) {
		return depotMapper.getDepotByCond (page , depotId , depotAddress);
	}
	
	public int addDepot (Depot depot) {
		return depotMapper.addDepot (depot);
	}
	
	public int updateDepot (Depot depot) {
		return depotMapper.updateDepot (depot);
	}
	
	public int delMulDepot (List<Integer> depotIds) {
		return depotMapper.delMulDepot (depotIds);
	}
}