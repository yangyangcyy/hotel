package com.example.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Renew;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RenewMapper extends BaseMapper<Renew> {
	Page<Renew> getRenewByCond (Page page , Integer checkinId);
	
	int addRenew (Renew renew);
}