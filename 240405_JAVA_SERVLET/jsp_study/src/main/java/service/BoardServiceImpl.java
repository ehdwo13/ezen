package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDAO bdao;
	
	public BoardServiceImpl() {
		bdao = new BoardDAOImpl();
	}

	@Override
	public int register(BoardVO bvo) {
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> getList(PagingVO pgvo) {
		log.info("test 1");
		return bdao.getList(pgvo);
	}

	@Override
	public BoardVO detail(int bno) {
		return bdao.getDetail(bno);
	}

	@Override
	public int update(BoardVO bvo) {
		return bdao.update(bvo);
	}

	@Override
	public int delete(int bno) {
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
