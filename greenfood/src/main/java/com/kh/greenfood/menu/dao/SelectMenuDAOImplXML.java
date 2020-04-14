package com.kh.greenfood.menu.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.kh.greenfood.menu.vo.SelectMenuVO;

@Repository
public class SelectMenuDAOImplXML implements SelectMenuDAO {

	private static final Logger logger 
	= LoggerFactory.getLogger(SelectMenuDAOImplXML.class);
	
	@Inject
	SqlSessionTemplate sqlSession;
	

	@Override
	public int choiceMenu(SelectMenuVO selectMenuVO) {
		logger.info("choiceMenu(int mnum, String sid) 호출됨!");

		return sqlSession.insert("mappers.SelectMenuDAO-mapper.choiceMenu" , selectMenuVO);
	}

	//선택 식단목록 조회
	@Override
	public List<SelectMenuVO> listMenu() {
		logger.info("list");
		return sqlSession.selectList("mappers.SelectMenuDAO-mapper.listMenu");
	}

	//선택 식단목록 취소
	@Override
	public int deleteMenu(String snum) {
		return sqlSession.delete("mappers.SelectMenuDAO-mapper.deleteMenu", Long.valueOf(snum));
	}

}
