package com.ezen.test.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ezen.test.domain.BoardDTO;
import com.ezen.test.domain.BoardVO;
import com.ezen.test.domain.FileVO;
import com.ezen.test.domain.PagingVO;
import com.ezen.test.handler.FileHandler;
import com.ezen.test.handler.PagingHandler;
import com.ezen.test.service.BoardService;
import com.ezen.test.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/board/*")
@Slf4j
@RequiredArgsConstructor
@Controller
public class BoardController {
	
	private final BoardService bsv;
	private final CommentService csv;
	private final FileHandler fhd;
	
	@GetMapping("/register")
	public void register() {}
	
	//@RequestParam("name")String name : 파라미터를 받을 때
	//required : 필수여부 false : 파라미터가 없어도 예외발생X
	@PostMapping("/insert")
	public String insert(BoardVO bvo, @RequestParam(name="files", required = false)MultipartFile[] files) {
		//파일 핸들러 처리
		//파일 저장처리 => fileList 리턴
		List<FileVO> flist = null;
		//파일이 있다면
		if(files[0].getSize() > 0) {
			//핸들러 호출
			flist = fhd.uploadFiles(files);
//			log.info("flist > {}", flist);
		}
		BoardDTO bdto = new BoardDTO(bvo, flist);
		int isOk = bsv.insert(bdto);
		return "redirect:/board/list";
	}
	@GetMapping("/list")
	public String list(Model m, PagingVO pgvo) {	//PagingVO 파라미터가 없으면 기본생성자 값이 뜬다.
		//리턴 타입은 목적지 경로에 대한 타입(destPage가 리턴)
		//Model 객체 => request.setAttribute 역할을 하는 객체
		int totalCount = bsv.getTotal(pgvo);
		PagingHandler ph = new PagingHandler(pgvo, totalCount);
		List<BoardVO> oldList = bsv.getList(pgvo);
		for(BoardVO blist : oldList) {
			bsv.fileCmt(blist.getBno());
			bsv.cmtCnt(blist.getBno());
		}
		List<BoardVO> list = bsv.getList(pgvo);
		m.addAttribute("list", list);
		m.addAttribute("ph",ph);
		return "/board/list";
	}
	//2개 케이스가 같을 경우
	//controller로 들어오는 경로와 jsp로 나가는 경로가 일치하면 void처리 할 수 있음.
	@GetMapping({"/detail","/modify"})
	public void detail(Model m, @RequestParam("bno")int bno) {
		BoardDTO bdto = bsv.getDetail(bno);
//		log.info("bdto > {}",bdto);
		m.addAttribute("bdto", bdto);
	}
	@PostMapping("/modify")
	public String modify(BoardVO bvo, @RequestParam(name="files", required = false)MultipartFile[] files) {
		List<FileVO> flist = null;
		if(files[0].getSize() > 0) {
			flist = fhd.uploadFiles(files);
		}
		BoardDTO bdto = new BoardDTO(bvo, flist);
		bsv.update(bdto);
		//새로운 데이터를 가지고 가야 함
		return "redirect:/board/detail?bno="+bvo.getBno();
	}
	@GetMapping("remove")
	public String remove(@RequestParam("bno")int bno) {
		List<FileVO> pathName = bsv.getPath(bno);
		for(int i=0; i<pathName.size(); i++) {
			log.info("test");
			String uuid = pathName.get(i).getUuid();
			String path = pathName.get(i).getSave_dir();
			String name = pathName.get(i).getFile_name();
			int isOk = fhd.deleteFile(path, uuid, name);
		}
		csv.removeAll(bno);
		bsv.remove(bno);
		return "redirect:/board/list";
	}
	@DeleteMapping(value = "/{uuid}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> remove(@PathVariable("uuid")String uuid){
		List<FileVO> delList = bsv.getPathByU(uuid);
		for(int i=0; i<delList.size(); i++) {
			String uuidD = delList.get(i).getUuid();
			String path = delList.get(i).getSave_dir();
			String name = delList.get(i).getFile_name();
			int isDel = fhd.deleteFile(path, uuidD, name);
		}
		int isOk = bsv.removeFile(uuid);
		return isOk > 0 ? new ResponseEntity<String>("1", HttpStatus.OK)
						: new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR) ;
		
	}
}
