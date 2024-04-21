package repository;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DatabaseBuilder;

public class MemberDAOImpl implements MemberDAO {
	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	private SqlSession sql;
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}
	@Override
	public int insert(MemberVO mvo) {
		int isOk = sql.insert("MemberMapper.new", mvo);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}
	@Override
	public MemberVO getLogin(MemberVO mvo) {
		return sql.selectOne("MemberMapper.login", mvo);
	}
	@Override
	public int update(MemberVO mvo) {
		int isOk = sql.update("MemberMapper.upd", mvo);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}
	@Override
	public int lastLogin(String id) {
		int isOk = sql.update("MemberMapper.ll", id);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}
	@Override
	public int delete(String id) {
		int isOk = sql.delete("MemberMapper.del", id);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}
	

}
