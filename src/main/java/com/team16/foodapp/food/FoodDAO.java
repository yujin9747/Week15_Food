package com.team16.foodapp.food;

import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FoodDAO {
	@Autowired
	SqlSession sqlSession; 
	
	public int insertFood(FoodVO vo) {
		String date = vo.getExpirationdate() ;
		String[] arr = date.split("/") ;
		if(arr.length != 3) return 0 ;
		int result = sqlSession.insert("Food.insertFood", vo) ;
		return result ;
	}

	public int deleteFood(int id) {
		int result = sqlSession.delete("Food.deleteFood", id) ;
		return result ;
	}
	
	public int updateFood(FoodVO vo) {
		int result = sqlSession.update("Food.updateFood", vo) ;
		return result ;
	}	
	
	public FoodVO getFood(int seq) {
		FoodVO one = sqlSession.selectOne("Food.getFood", seq) ;
		return one ;
	}
	
	public List<FoodVO> getFoodList(){
		List<FoodVO> list = sqlSession.selectList("Food.getFoodList") ;
		return list ;
	}
	
	public int dDaynotification(FoodVO vo) {
		int d_Day = 0;
		
		//비교할 날짜
	    Calendar target = Calendar.getInstance();
	    String date = vo.getExpirationdate() ;
	    String[] arr = date.split("/") ;
	    target.set(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])-1, Integer.parseInt(arr[2]));
	      
	      // 현재 날짜
	    Calendar present = Calendar.getInstance();
	       
	      // 5. D- Day 계산
	     long time =  (target.getTimeInMillis() - present.getTimeInMillis())/(24*60*60*1000);
	     d_Day = (int) time;
	     if(d_Day < 0) sqlSession.update("Food.setExpired", vo) ; 
	     return d_Day ;
	       
	  }

	public int completeFood(FoodVO vo) {
		int result = sqlSession.update("Food.completeFood", vo) ;
		return result ;
	}
}

