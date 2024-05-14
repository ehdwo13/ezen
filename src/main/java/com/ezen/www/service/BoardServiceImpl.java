package com.ezen.www.service;

import com.ezen.www.domain.BoardVO;
import com.ezen.www.repository.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{
    private final BoardMapper boardMapper;

    @Override
    public int insert(BoardVO bvo) {
        int isOk = boardMapper.insert(bvo);
//        log.info("test 2{}",isOk);
        return isOk;
    }

    @Override
    public List<BoardVO> getList() {
        return boardMapper.getList();
    }

    @Override
    public BoardVO getDetail(long bno) {
        return boardMapper.getDetail(bno);
    }

    @Override
    public void update(BoardVO bvo) {
        boardMapper.update(bvo);
    }

    @Override
    public void remove(long bno) {
        boardMapper.remove(bno);
    }
}
