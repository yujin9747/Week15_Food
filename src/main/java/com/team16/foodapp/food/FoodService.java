package com.team16.foodapp.food;

import java.util.List;

public interface FoodService {
	public int insertFood(FoodVO vo);
	public int deleteFood(int id);
	public int updateFood(FoodVO vo);
	public FoodVO getFood(int seq);
	public List<FoodVO> getFoodList();
}
