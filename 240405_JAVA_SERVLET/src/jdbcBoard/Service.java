package jdbcBoard;

import java.util.List;

public interface Service {

	int register(BoardVO b);

	BoardVO search(int bno);

	int modify(BoardVO b);

	int remove(int bno);

	List<BoardVO> getList();

}
