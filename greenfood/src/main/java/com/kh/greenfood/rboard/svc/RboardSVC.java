package com.kh.greenfood.rboard.svc;

import java.util.List;

import com.kh.greenfood.rboard.vo.RboardVO;

public interface RboardSVC {
	//댓글 작성
	int replyWrite(RboardVO rboardVO);
	//댓글수정
	int replyModify(RboardVO rboardVO);
	//댓글 삭제
	int replyDelete(String rnum);
	//대댓글 작성
	int rereplyWrite(RboardVO rboardVO);

	//댓글 목록 보기
	List<RboardVO> replyList(int bnum, int startRec, int endRec); 
	//댓글 총계
	int replyAll(String bnum);
}
