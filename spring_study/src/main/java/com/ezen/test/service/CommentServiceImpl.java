package com.ezen.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ezen.test.domain.CommentVO;
import com.ezen.test.repository.CommentDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService{
	
	private final CommentDAO cdao;

	@Override
	public int post(CommentVO cvo) {
		return cdao.post(cvo);
	}

	@Override
	public List<CommentVO> getList(int bno) {
		return cdao.getList(bno);
	}

	@Override
	public int modify(CommentVO cvo) {
		return cdao.modify(cvo);
	}

	@Override
	public int remove(int cno) {
		return cdao.remove(cno);
	}

	@Override
	public void removeAll(int bno) {
		cdao.removeAll(bno);
		
	}
}
