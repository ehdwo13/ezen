package com.ezen.www.controller;

import com.ezen.www.domain.BoardDTO;
import com.ezen.www.domain.BoardVO;
import com.ezen.www.domain.FileVO;
import com.ezen.www.domain.PagingVO;
import com.ezen.www.handler.FileHandler;
import com.ezen.www.handler.PagingHandler;
import com.ezen.www.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board/*")
@Controller
public class BoardController {
    private final BoardService bsv;
    private final FileHandler fh;

    @GetMapping("/register")
    public void register(){}

    @PostMapping("/register")
    public String register(BoardVO bvo, @RequestParam("files") MultipartFile[] files){
        List<FileVO> flist= null;
        if(files[0].getSize() > 0) {
            flist = fh.uploadFiles(files);
        }
        BoardDTO bdto = new BoardDTO(bvo, flist);
        int isOk = bsv.insert(bdto);
        return "redirect:/board/list";
    }
    @GetMapping("/list")
    public String list(Model m, PagingVO pgvo){
        int totalCount = bsv.getTotal(pgvo);
        PagingHandler ph = new PagingHandler(pgvo, totalCount);
        m.addAttribute("list", bsv.getList(pgvo));
        m.addAttribute("ph",ph);
        return "/board/list";
    }

    @GetMapping("/detail")
    public void detail(Model m, @RequestParam("bno")long bno) {
        BoardVO bvo = bsv.getDetail(bno);
        m.addAttribute("bvo", bvo);
    }

    @PostMapping("/modify")
    public String modify(BoardVO bvo){
        bsv.update(bvo);
        return "redirect:/board/detail?bno="+bvo.getBno();
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno")long bno){
        bsv.remove(bno);
        return "redirect:/board/list";
    }
}
