package repository;

import java.util.List;

import domain.MemberVO;

public interface MemberDAO {

	int insert(MemberVO mvo);

	List<MemberVO> selectList();

	MemberVO getID(MemberVO mvo);

	int lastLogin(String id);

	int update(MemberVO updateMvo);

	int delete(String id);

}
