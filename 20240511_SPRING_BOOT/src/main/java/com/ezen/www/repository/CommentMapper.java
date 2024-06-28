package com.ezen.www.repository;

import com.ezen.www.domain.CommentVO;
import com.ezen.www.domain.PagingVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    int post(CommentVO cvo);

    List<CommentVO> getList(@Param("bno")int bno, @Param("pgvo") PagingVO pgvo);

    int getSelectOneBnoTotalCount(int bno);

    int update(CommentVO cvo);

    int del(int cno);
}
