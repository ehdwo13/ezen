package jdbcBoard;

import java.util.List;

public class BoardServiceImpl implements Service{
	
	private jdbcBoard.DAO dao;
	public BoardServiceImpl() {
		dao = new BoardDAOImpl();
	}
	@Override
	public int register(BoardVO b) {
		System.out.println("register serviceImpl success");
		return dao.insert(b);
	}
	@Override
	public BoardVO search(int bno) {
		System.out.println("selectOne serviceImpl success");
		return dao.selectOne(bno);
	}
	@Override
	public int modify(BoardVO b) {
		System.out.println("modify serviceImpl success");
		return dao.update(b);
	}
	@Override
	public int remove(int bno) {
		System.out.println("remove serviceImpl success");
		return dao.remove(bno);
		
	}
	@Override
	public List<BoardVO> getList() {
		System.out.println("getList serviceImpl success");
		return dao.select();
	}
}
