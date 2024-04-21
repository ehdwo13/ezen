package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import domain.BoardVO;
import orm.DatabaseBuilder;

public class BoardDAOImpl implements BoardDAO {
	
	private SqlSession sql;
	
	public BoardDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(BoardVO bvo) {
		int isOk = sql.insert("BoardMapper.in", bvo);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public List<BoardVO> getList() {
		return sql.selectList("BoardMapper.list");
	}

	@Override
	public BoardVO getDetail(int bno) {
		return sql.selectOne("BoardMapper.one", bno);
	}

	@Override
	public int update(BoardVO bvo) {
		int isOk = sql.update("BoardMapper.up", bvo);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int delete(int bno) {
		int isOk = sql.delete("BoardMapper.del", bno);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}
}
