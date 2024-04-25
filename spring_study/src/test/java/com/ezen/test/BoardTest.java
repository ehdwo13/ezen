package com.ezen.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezen.test.domain.BoardVO;
import com.ezen.test.repository.BoardDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardTest {
	
	@Inject
	private BoardDAO bdao;
	@Test
	public void insertBoard() {
		log.info("Test Insert in");
		for(int i=10; i<300; i++) {
			BoardVO bvo = new BoardVO();
			bvo.setTitle("테스트"+i);
			bvo.setWriter("테스트"+i);
			bvo.setContent("테스트"+i);
			bdao.insert(bvo);
		}
	}
}
