package com.kh.greenfood.menu.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.greenfood.member.vo.MemberVO;
import com.kh.greenfood.menu.svc.MenuSVC;
import com.kh.greenfood.menu.svc.SelectMenuSVC;
import com.kh.greenfood.menu.vo.MenuVO;
import com.kh.greenfood.menu.vo.SelectMenuVO;
import com.kh.greenfood.product.svc.ProductSVC;

@Controller
@RequestMapping("/menu")
public class SelectMenuController {
	
	private final Logger logger
	= LoggerFactory.getLogger(SelectMenuController.class);
	
	@Inject
	MenuSVC menuSVC;
	@Inject
	ProductSVC productSVC;
	@Inject
	SelectMenuSVC selectMenuSVC;
	
	//그린정식 식단선택
	@PostMapping(value="/select/{rnum}",produces="application/json" )
	@ResponseBody
	public ResponseEntity<String> selectJS3(
			@RequestBody List<SelectMenuVO> list, 
			@PathVariable("rnum") String rnum,
			HttpSession session) {
		ResponseEntity<String> res = null;

		logger.info("selectMenuVO:"+list.toString());
		logger.info("rnum:" +  rnum);
		
		selectMenuSVC.choiceMenu(list);
		
		res = new ResponseEntity<String>("success",  HttpStatus.OK);
		return res;
	}	
	//그린정식 불러오기
	@GetMapping("/select/{rnum}")
	public String selectJS(
			@PathVariable("rnum") String rnum,
			Model model ) {
		
		List<MenuVO> list = menuSVC.listJS();
		
		model.addAttribute("list", list);
		model.addAttribute("rnum", rnum);
		return "menu/selectMenu";
	}
	
//그린덮밥 식단선택
	@PostMapping(value="/select2/{rnum}",produces="application/json" )
	@ResponseBody
	public ResponseEntity<String> selectRice(
			@RequestBody List<SelectMenuVO> list, 
			@PathVariable("rnum") String rnum,
			HttpSession session) {
		ResponseEntity<String> res = null;

		logger.info("selectMenuVO:"+list.toString());
		logger.info("rnum:" +  rnum);
		
		selectMenuSVC.choiceMenu(list);
		
		res = new ResponseEntity<String>("success",  HttpStatus.OK);
		return res;
	}	
	
	//그린덮밥 식단표 선택/불러오기
	@GetMapping("/select2/{rnum}")
	public String greenRice(
			@PathVariable("rnum") String rnum,
			Model model) {
		List<MenuVO> list = menuSVC.listRice();
		
		model.addAttribute("list", list);
		model.addAttribute("rnum", rnum);
		return "menu/selectMenu";
	}
	
	//그린스페셜 선택하기
	@PostMapping(value="/select3/{rnum}",produces="application/json" )
	@ResponseBody
	public ResponseEntity<String> selectSP(
			@RequestBody List<SelectMenuVO> list, 
			@PathVariable("rnum") String rnum,
			HttpSession session) {
		ResponseEntity<String> res = null;

		logger.info("selectMenuVO:"+list.toString());
		logger.info("rnum:" +  rnum);
		
		selectMenuSVC.choiceMenu(list);
		
		res = new ResponseEntity<String>("success",  HttpStatus.OK);
		return res;
	}	
	//그린스페셜 식단표 선택/불러오기
	@GetMapping("/select3/{rnum}")
	public String greenSP(
			@PathVariable("rnum") String rnum,
			Model model) {
		List<MenuVO> list = menuSVC.listSP();
		
		model.addAttribute("list", list);
		model.addAttribute("rnum", rnum);
		return "menu/selectMenu";
	}
	
	//그린다이어트 식단선택
	@PostMapping(value="/select4/{rnum}",produces="application/json" )
	@ResponseBody
	public ResponseEntity<String> selectDiet(
			@RequestBody List<SelectMenuVO> list, 
			@PathVariable("rnum") String rnum,
			HttpSession session) {
		ResponseEntity<String> res = null;

		logger.info("selectMenuVO:"+list.toString());
		logger.info("rnum:" +  rnum);
		
		selectMenuSVC.choiceMenu(list);
		
		res = new ResponseEntity<String>("success",  HttpStatus.OK);
		return res;
	}	
	//그린다이어트 식단표 선택/불러오기
	@GetMapping("/select4/{rnum}")
	public String greenDiet(
			@PathVariable("rnum") String rnum,
			Model model) {
		List<MenuVO> list = menuSVC.listDiet();
		
		model.addAttribute("list", list);
		model.addAttribute("rnum", rnum);
		return "menu/selectMenu";
	}
}
