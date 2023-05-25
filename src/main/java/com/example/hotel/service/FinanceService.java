package com.example.hotel.service;

import com.example.hotel.entity.Finance;
import com.example.hotel.mapper.FinanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FinanceService {
	@Autowired
	FinanceMapper financeMapper;
	
	public List<Finance> getFoodFinanceByCond (Date beginTime , Date endTime) {
		return financeMapper.getFoodFinanceByCond (beginTime , endTime);
	}
}