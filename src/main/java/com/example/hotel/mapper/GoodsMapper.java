package com.example.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
	Page<Goods> getGoodsByCond (Page page , Integer goodsId , String goodsName);
	
	int addGoods (Goods goods);
	
	int updateGoods (Goods goods);
	
	int delMulGoods (List<Integer> goodsIds);
}