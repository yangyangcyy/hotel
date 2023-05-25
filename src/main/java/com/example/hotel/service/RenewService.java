package com.example.hotel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Renew;
import com.example.hotel.mapper.RenewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RenewService {
	@Autowired
	RenewMapper renewMapper;
	
	public Page<Renew> getRenewByCond (Page page , Integer checkinId) {
		return renewMapper.getRenewByCond (page , checkinId);
	}
	
	public int addRenew (Renew renew) {
		return renewMapper.addRenew (renew);
	}
}