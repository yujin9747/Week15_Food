package com.team16.foodapp.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FoodController {

	@Autowired
	FoodDAO foodDAO;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String foodList(Model model) {
		model.addAttribute("list", foodDAO.getFoodList());
		return "list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addFood() {
		return "addfoodform";
	}

	@RequestMapping(value = "/addok", method = RequestMethod.POST)
	public String addFoodOk(FoodVO vo) {
		int i = foodDAO.insertFood(vo);
		if (i == 0)
			System.out.println("데이터 추가 실패!");
		else
			System.out.println("데이터 추가 성공!");
		return "redirect:list";
	}

	@RequestMapping(value = "/editfood/{id}", method = RequestMethod.GET)
	public String editPost(@PathVariable("id") int id, Model model) {
		FoodVO foodVO = foodDAO.getFood(id);
		model.addAttribute("foodVO", foodVO);
		return "editform";
	}

	@RequestMapping(value = "/editok", method = RequestMethod.POST)
	public String editFoodOk(FoodVO vo) {
		int i = foodDAO.updateFood(vo);
		if (i == 0)
			System.out.println("데이터 수정 실패!");
		else
			System.out.println("데이터 수정 성공!");
		return "redirect:list";
	}

	@RequestMapping(value = "/deleteok/{id}", method = RequestMethod.GET)
	public String deleteFood(@PathVariable("id") int id) {
		int i = foodDAO.deleteFood(id);
		if (i == 0)
			System.out.println("데이터 삭제 실패!");
		else
			System.out.println("데이터 삭제 성공!");
		return "redirect:../list";
	}

}