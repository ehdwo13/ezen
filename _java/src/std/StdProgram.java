package std;

import java.util.Scanner;

public interface StdProgram {
	
	void printStd();				//학생정보출력
	void addStd(Scanner sc);		//학생추가
	void modStd(Scanner sc);		//학생수정
	void delStd(Scanner sc); 		//학생삭제
	void searchStd(Scanner sc); 	//학생검색
	void addSub(Scanner sc); 		//점수추가
	void modSub(Scanner sc);		//점수수정
	void delSub(Scanner sc);		//점수삭제
}
