package com.ezen.test.repository;

import com.ezen.test.domain.MemberVO;

public interface MemberDAO {

	int insert(MemberVO mvo);

	MemberVO getUser(String id);

}
