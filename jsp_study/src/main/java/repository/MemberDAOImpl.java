package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import domain.MemberVO;
import orm.DatabaseBuilder;

public class MemberDAOImpl implements MemberDAO{
	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	private SqlSession sql;
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}
	@Override
	public int insert(MemberVO mvo) {
		int isOk = sql.insert("MemberMapper.add", mvo);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}
	@Override
	public List<MemberVO> selectList() {
		return sql.selectList("MemberMapper.list");
	}
	@Override
	public MemberVO getID(MemberVO mvo) {
		return sql.selectOne("MemberMapper.login",mvo);
	}
	@Override
	public int lastLogin(String id) {
		int isOk = sql.update("MemberMapper.last", id);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}
	@Override
	public int update(MemberVO updateMvo) {
		int isOk = sql.update("MemberMapper.update", updateMvo);
		if(isOk> 0) {
			sql.commit();
		}
		return isOk;
	}
	@Override
	public int delete(String id) {
		int isOk = sql.delete("MemberMapper.delete", id);
		if(isOk> 0) {
			sql.commit();
		}
		return isOk;
	}
}
