package com.example.hotel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.DiningReserve;
import com.example.hotel.entity.ReserveFood;
import com.example.hotel.mapper.DiningReserveMapper;
import com.example.hotel.mapper.ReserveFoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiningReserveService {
	@Autowired
	DiningReserveMapper diningReserveMapper;
	@Autowired
	ReserveFoodMapper reserveFoodMapper;
	
	public Page<DiningReserve> getDiningReserveByCond (Page page , Integer reserveId , String customerId , Integer tableId , String status) {
		return diningReserveMapper.getDiningReserveByCond (page , reserveId , customerId , tableId , status);
	}
	
	public Page<ReserveFood> getReserveFoodByCond (Page page , Integer reserveId , Integer foodId) {
		return reserveFoodMapper.getReserveFoodByCond (page , reserveId , foodId);
	}
	
	public void diningReserve (DiningReserve diningReserve , List<ReserveFood> reserveFoods) {
		diningReserveMapper.addDiningReserve (diningReserve);
		DiningReserve diningReserve1 = new DiningReserve ();
		diningReserve1.setReserveId (diningReserveMapper.selectId ());
		for (ReserveFood reserveFood : reserveFoods) {
			reserveFood.setDiningReserve (diningReserve1);
		}
		reserveFoodMapper.addMulReserveFood (reserveFoods);
	}
	
	public void updateReserveFood (List<ReserveFood> reserveFoods) {
		List<ReserveFood> newReserveFoods = new ArrayList<> ();
		List<ReserveFood> allReserveFoods = new ArrayList<> ();
		for (ReserveFood reserveFood : reserveFoods) {
			allReserveFoods.add (reserveFood);
		}
		for (ReserveFood reserveFood : reserveFoods) {
			if (reserveFoodMapper.existsReserveFood (reserveFood) == 0) {
				newReserveFoods.add (reserveFood);
				allReserveFoods.remove (reserveFood);
			}
		}
//		System.out.println (newReserveFoods);
//		System.out.println (allReserveFoods);
		if (allReserveFoods.size () > 0) {
			reserveFoodMapper.updateMulReserveFood (allReserveFoods);
		}
		if (newReserveFoods.size () > 0) {
			reserveFoodMapper.addMulReserveFood (newReserveFoods);
		}
	}
	
	public int updateDiningReserve (DiningReserve diningReserve) {
		return diningReserveMapper.updateDiningReserve (diningReserve);
	}
}