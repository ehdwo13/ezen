package com.ezen.test.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.test.domain.BoardVO;
import com.ezen.test.domain.PagingVO;
import com.ezen.test.handler.PagingHandler;
import com.ezen.test.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/board/*")
@Slf4j
@RequiredArgsConstructor
@Controller
public class BoardController {
	
	private final BoardService bsv;
	
	@GetMapping("/register")
	public void register() {}
	
	//@RequestParam("name")String name : 파라미터를 받을 때
	@PostMapping("/insert")
	public String insert(BoardVO bvo) {
		log.info("bvo > {}",bvo);
		int isOk = bsv.insert(bvo);
		log.info("isOk check > {}", isOk);
		return "redirect:/board/list";
	}
	@GetMapping("/list")
	public String list(Model m, PagingVO pgvo) {	//PagingVO 파라미터가 없으면 기본생성자 값이 뜬다.
		//리턴 타입은 목적지 경로에 대한 타입(destPage가 리턴)
		//Model 객체 => request.setAttribute 역할을 하는 객체
		int totalCount = bsv.getTotal(pgvo);
		PagingHandler ph = new PagingHandler(pgvo, totalCount);
		List<BoardVO> list = bsv.getList(pgvo);
		m.addAttribute("list", list);
		m.addAttribute("ph",ph);
		return "/board/list";
	}
	//2개 케이스가 같을 경우
	//controller로 들어오는 경로와 jsp로 나가는 경로가 일치하면 void처리 할 수 있음.
	@GetMapping({"/detail","/modify"})
	public void detail(Model m, @RequestParam("bno")int bno) {
		log.info("bno > {}",bno);
		BoardVO bvo = bsv.getDetail(bno);
		m.addAttribute("bvo", bvo);
	}
	@PostMapping("/modify")
	public String modify(BoardVO bvo) {
		log.info("modify bvo > {}",bvo);
		bsv.update(bvo);
		//새로운 데이터를 가지고 가야 함
		return "redirect:/board/detail?bno="+bvo.getBno();
	}
	@GetMapping("remove")
	public String remove(@RequestParam("bno")int bno) {
		bsv.remove(bno);
		return "redirect:/board/list";
	}
}
