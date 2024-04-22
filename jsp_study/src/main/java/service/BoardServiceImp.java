package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import domain.BoardVO;
import domain.PagingVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;
import repository.CommentDAO;

public class BoardServiceImp implements BoardService {
	
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImp.class);
	private BoardDAO bdao;
	
	public BoardServiceImp() {
		bdao = new BoardDAOImpl();
	}

	@Override
	public int register(BoardVO bvo) {
		log.info("register service in");
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> getList(PagingVO pgvo) {
//		log.info("getList service in");
		return bdao.selectList(pgvo);
	}

	@Override
	public BoardVO getDetail(int bno) {
		return bdao.selectOne(bno);
	}

	@Override
	public int update(BoardVO bvo) {
		log.info("update service in");
		return bdao.update(bvo);
	}

	@Override
	public int delete(int bno) {
		log.info("delete service in");
		return bdao.delete(bno);
	}

	@Override
	public int getTotal(PagingVO pgvo) {
		return bdao.totalCount(pgvo);
	}

	@Override
	public String getFilePath(int bno) {
		return bdao.getFilePath(bno);
	}

	@Override
	public int removeComment(int bno) {
		CommentServiceImpl csv = new CommentServiceImpl();
		return csv.removeComment(bno);
	}

	
}
