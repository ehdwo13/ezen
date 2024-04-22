package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import orm.DatabaseBuilder;

public class BoardDAOImpl implements BoardDAO {
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
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

	@Override
	public List<BoardVO> getList(PagingVO pgvo) {
		log.info("test 2");
		return sql.selectList("BoardMapper.list", pgvo);
	}

	@Override
	public int totalCount(PagingVO pgvo) {
		int total = sql.selectOne("BoardMapper.tot", pgvo);
		return total;
	}
}
