package repository;

import domain.MemberVO;

public interface MemberDAO {

	int insert(MemberVO mvo);

	MemberVO getLogin(MemberVO mvo);

	int update(MemberVO mvo);

	int lastLogin(String id);

	int delete(String id);

}
