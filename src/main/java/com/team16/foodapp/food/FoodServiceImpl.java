package com.team16.foodapp.food;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService{
	
	@Autowired
	FoodDAO foodDAO;
	
	@Override
	public int insertFood(FoodVO vo) {
		return foodDAO.insertFood(vo);
	}
	
	@Override
	public int deleteFood(int id) {
		return	foodDAO.deleteFood(id);
	}
	
	@Override
	public int updateFood(FoodVO vo) {
		return foodDAO.updateFood(vo);
 	}
	
	@Override
	public FoodVO getFood(int seq) {
		return foodDAO.getFood(seq);
	}
	
	@Override
	public List<FoodVO> getFoodList(){
		return foodDAO.getFoodList();
	}

	
}
