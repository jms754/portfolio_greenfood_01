package com.kh.greenfood.menu.svc;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kh.greenfood.menu.dao.SelectMenuDAO;
import com.kh.greenfood.menu.vo.MenuVO;
import com.kh.greenfood.menu.vo.SelectMenuVO;

@Service
public class SelectMenuSVCImpl implements SelectMenuSVC {

	private static final Logger logger
		= LoggerFactory.getLogger(SelectMenuSVCImpl.class);
	
	@Inject
	SelectMenuDAO selectMenuDAO;
	
	//식단 선택 완료
	@Transactional
	@Override
	public int choiceMenu(List<SelectMenuVO> list) {
		logger.info(list.toString());
		int cnt = 0;
		for(SelectMenuVO rec: list) {
		 cnt = selectMenuDAO.choiceMenu(rec);
		}
		return cnt;
	}

	//선택 식단목록 조회
	@Override
	public List<SelectMenuVO> listMenu() {
		return selectMenuDAO.listMenu();
	}

	@Override
	public int deleteMenu(String snum) {
		int cnt = 0;
		cnt = selectMenuDAO.deleteMenu(snum);
		return cnt;
	}

}
