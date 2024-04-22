package service;

import java.util.List;

import domain.CommentVO;

public interface CommentService {

	int register(CommentVO cvo);

	List<CommentVO> getList(int bno);

	int remove(int cno);

	int modify(CommentVO cvo);

	int removeComment(int bno);
}
