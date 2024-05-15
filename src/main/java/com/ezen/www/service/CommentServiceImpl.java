package com.ezen.www.service;

import com.ezen.www.repository.CommentMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import com.ezen.www.domain.CommentVO;
import com.ezen.www.domain.PagingVO;
import com.ezen.www.handler.PagingHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService{

    private final CommentMapper commentMapper;

    @Override
    public int post(CommentVO cvo) {
        return commentMapper.post(cvo);
    }

    @Override
    public PagingHandler getList(int bno, PagingVO pgvo) {
        List<CommentVO> list = commentMapper.getList(bno, pgvo);

        int totalCount = commentMapper.getSelectOneBnoTotalCount(bno);
        PagingHandler ph = new PagingHandler(pgvo, totalCount, list);
        return ph;
    }

    @Override
    public int update(CommentVO cvo) {
        return commentMapper.update(cvo);
    }

    @Override
    public int delete(int cno) {
        return commentMapper.del(cno);
    }

}
