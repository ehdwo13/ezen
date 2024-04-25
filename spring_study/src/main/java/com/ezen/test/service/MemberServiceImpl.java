package com.ezen.test.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ezen.test.domain.MemberVO;
import com.ezen.test.repository.MemberDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{
	
	private final MemberDAO mdao;
	final BCryptPasswordEncoder passwordEncoder;

	@Override
	public int insert(MemberVO mvo) {
		// 아이디 중복체크 회원가입 실패
		// 아이디만 주고, DB에서 일치하는 mvo 객체를 리턴 => 일치하는 객체가 있다면 가입실패 / 없으면 가능
		MemberVO tempMvo = mdao.getUser(mvo.getId());
		if(tempMvo != null) {
			return 0;
		}
		// 아이디가 중복되지 않는다면 회원가입 진행
		// password가 null이거나 값이 없다면 가입불가
		if(mvo.getId() == null || mvo.getId().length() == 0) {
			return 0;
		}
		if(mvo.getPw() == null || mvo.getPw().length() == 0) {
			return 0;
		}
		// 회원가입
		// password 암호화하여 가입
		// encode() 암호화 / matches(입력된비번, 암호화된 비번) => true, false
//		String pw = mvo.getPw();
//		String encodePW = passwordEncoder.encode(pw);
//		mvo.setPw(encodePW);
		
		mvo.setPw(passwordEncoder.encode(mvo.getPw()));
		int isOk = mdao.insert(mvo);
		return isOk;
	}

	@Override
	public MemberVO isUser(MemberVO mvo) {
		// 로그인 유저 확인
		MemberVO tempMvo = mdao.getUser(mvo.getId());
		// 해당 아이디가 없으면 
		if(tempMvo == null) {
			return null;
		}
		// 해당 아이디가 있으면 matches(원래비번, 암호회된 비번) 비교
		if(passwordEncoder.matches(mvo.getPw(), tempMvo.getPw())){
			return tempMvo;
		}
		return null;
	}
}
