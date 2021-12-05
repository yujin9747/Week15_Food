package com.team16.foodapp.food;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class FoodDAO {
	
	private JdbcTemplate template ;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template ;
	}

	private final String FOOD_INSERT = "insert into food (name, memo, expirationdate) values (?,?,?)";
	private final String FOOD_UPDATE = "update food set name=?, memo=?, expirationdate=? where id=?";
	private final String FOOD_DELETE = "delete from food  where id=?";
	private final String FOOD_GET = "select * from food where id=?";
	private final String FOOD_LIST = "select * from food order by expirationdate";
	
	public int insertFood(FoodVO vo) {
		return template.update(FOOD_INSERT, new Object[] {vo.getName(), vo.getMemo(), vo.getExpirationdate()});
	}

	public int deleteFood(int id) {
		return template.update(FOOD_DELETE, new Object[] {id}) ;
	}
	public int updateFood(FoodVO vo) {
		return template.update(FOOD_UPDATE, new Object[] {vo.getName(), vo.getMemo(), vo.getExpirationdate(), vo.getId()});
	}	
	
	public FoodVO getFood(int seq) {
		return template.queryForObject(FOOD_GET, new Object[] {seq}, new BeanPropertyRowMapper<FoodVO>(FoodVO.class)) ;
	}
	
	public List<FoodVO> getFoodList(){
		return template.query(FOOD_LIST, new RowMapper<FoodVO>() {
			
			@Override
			public FoodVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				FoodVO data = new FoodVO() ;
				data.setId(rs.getInt("id")) ;
				data.setName(rs.getString("name")) ;
				data.setMemo(rs.getString("memo")) ;
				data.setExpirationdate(rs.getDate("expirationdate")) ;
				data.setExpired(rs.getInt("expired")) ;
				return data ;
			}
		}) ;
	}
}
