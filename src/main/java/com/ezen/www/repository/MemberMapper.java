package com.ezen.www.repository;

import com.ezen.www.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int insert(MemberVO mvo);

    int insertAuth(String email);
}
