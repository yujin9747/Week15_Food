package com.team16.foodapp.food;

public class FoodVO {
	private int id ;
	private String name ;
	private String memo ;
	private String expirationdate ;
	private int comp ;
	private String inventory ;
	private String price ;
	
	public String getInventory() {
		return inventory;
	}
	public void setInventory(String inventory) {
		this.inventory = inventory;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getExpirationdate() {
		return expirationdate;
	}
	public void setExpirationdate(String expirationdate) {
		this.expirationdate = expirationdate;
	}
	public int getComp() {
		return comp;
	}
	public void setComp(int comp) {
		this.comp = comp;
	}
}
