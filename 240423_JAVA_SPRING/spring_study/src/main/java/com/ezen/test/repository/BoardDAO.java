package com.ezen.test.repository;

import java.util.List;

import com.ezen.test.domain.BoardVO;
import com.ezen.test.domain.PagingVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	List<BoardVO> getList(PagingVO pgvo);

	BoardVO getDetail(int bno);

	int update(BoardVO bvo);

	void remove(BoardVO bvo);

	void updateIsDel(int bno);

	void readCount(int bno);

	int totalCount(PagingVO pgvo);

	int selectBno();

	void fileCmt(int bno);

	void cmtCnt(int bno);



}
