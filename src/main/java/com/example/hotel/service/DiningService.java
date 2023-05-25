package com.example.hotel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.ActualFood;
import com.example.hotel.entity.Dining;
import com.example.hotel.mapper.ActualFoodMapper;
import com.example.hotel.mapper.DiningMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiningService {
	@Autowired
	DiningMapper diningMapper;
	@Autowired
	ActualFoodMapper actualFoodMapper;
	
	public Page<Dining> getDiningByCond (Page page , Integer diningId , String customerId , Integer tableId , Integer empId , String status) {
		return diningMapper.getDiningByCond (page , diningId , customerId , tableId , empId , status);
	}
	
	public Page<ActualFood> getActualFoodByCond (Page page , Integer diningId , Integer foodId) {
		return actualFoodMapper.getActualFoodByCond (page , diningId , foodId);
	}
	
	public void dining (Dining dining , List<ActualFood> actualFoods) {
		diningMapper.addDining (dining);
		Dining dining1 = new Dining ();
		dining1.setDiningId (diningMapper.selectId ());
		for (ActualFood actualFood : actualFoods) {
			actualFood.setDining (dining1);
		}
		actualFoodMapper.addMulActualFood (actualFoods);
	}
	
	public void updateActualFood (List<ActualFood> actualFoods) {
		List<ActualFood> newActualFoods = new ArrayList<> ();
		List<ActualFood> allActualFoods = new ArrayList<> ();
		for (ActualFood actualFood : actualFoods) {
			allActualFoods.add (actualFood);
		}
		for (ActualFood actualFood : actualFoods) {
			if (actualFoodMapper.existsActualFood (actualFood) == 0) {
				newActualFoods.add (actualFood);
				allActualFoods.remove (actualFood);
			}
		}
		if (allActualFoods.size () > 0) {
			actualFoodMapper.updateMulActualFood (allActualFoods);
		}
		if (newActualFoods.size () > 0) {
			actualFoodMapper.addMulActualFood (newActualFoods);
		}
	}
	
	public int updateDining (Dining dining) {
		return diningMapper.updateDining (dining);
	}
}