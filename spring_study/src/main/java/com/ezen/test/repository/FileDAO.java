package com.ezen.test.repository;

import java.util.List;

import com.ezen.test.domain.FileVO;

public interface FileDAO {

	int insertFile(FileVO fvo);

	List<FileVO> getFileList(int bno);

	int removeOne(String uuid);

	void removeAll(int bno);

	List<FileVO> getPathList(int bno);

	List<FileVO> getPathListByU(String uuid);

}
