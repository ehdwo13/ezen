package com.ezen.test.repository;

import com.ezen.test.domain.MemberVO;

public interface MemberDAO {

	int insert(MemberVO mvo);

	MemberVO getUser(String id);

	void updateLastLogin(String id);

	void update(MemberVO mvo);

	void remove(String id);

}
