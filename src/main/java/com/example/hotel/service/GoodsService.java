package com.example.hotel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Goods;
import com.example.hotel.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
	@Autowired
	GoodsMapper goodsMapper;
	
	public Page<Goods> getGoodsByCond (Page page , Integer goodsId , String goodsName) {
		return goodsMapper.getGoodsByCond (page , goodsId , goodsName);
	}
	
	public int addGoods (Goods goods) {
		return goodsMapper.addGoods (goods);
	}
	
	public int updateGoods (Goods goods) {
		return goodsMapper.updateGoods (goods);
	}
	
	public int delMulGoods (List<Integer> goodsIds) {
		return goodsMapper.delMulGoods (goodsIds);
	}
}