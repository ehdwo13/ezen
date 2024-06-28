package com.ezen.www.service;

import java.util.List;

import com.ezen.www.domain.UserVO;

public interface UserService {

	void insert(UserVO uvo);

	List<UserVO> getAllList();

	void updateUser(UserVO uvo);

	void delete(String email);

	void updatePW(UserVO uvo);

	int checkEmail(String email);

}
