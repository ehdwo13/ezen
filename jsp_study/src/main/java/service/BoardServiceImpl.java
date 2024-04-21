package service;

import java.util.List;

import domain.BoardVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
	private BoardDAO bdao;
	
	public BoardServiceImpl() {
		bdao = new BoardDAOImpl();
	}

	@Override
	public int register(BoardVO bvo) {
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> getList() {
		return bdao.getList();
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
}
