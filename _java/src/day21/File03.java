package day21;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class File03 {

	public static void main(String[] args) throws IOException {
		// FileWriter를 이용한 파일 쓰기
		// 일반적으로 다시 같은 이름의 파일을 생성하면 덮어쓰기.
		// 기존 파일에 추가모드가 가능.
		
		FileWriter fw = new FileWriter("writer.txt");
		for(int i=1; i<=10; i++) {
			String data = i+ " test \r\n"; //\n Enter \r 캐리지리턴
			fw.write(data); //기록
			fw.write("my project I/O Test \r\n");
		}
		fw.close();
		
		//기존파일에 데이터를 쓰려고 할 때 : 추가모드
		FileWriter fw2 = new FileWriter("writer.txt",true);
		for(int i=11; i<=20; i++) {
			String data = i+ " test \r\n"; //\n Enter \r 캐리지리턴
			fw2.write(data); //기록
			fw2.write("my project I/O Test \r\n");
		}
		fw2.close();
		
		//PrintWriter를 이용한 파일 쓰기
		
		PrintWriter pw = new PrintWriter("booklist.txt");
		for(int i=1; i<=10; i++) {
			String data = i+ " 번째 도서 \r\n"; 
			pw.write(data); //기록
			pw.write("내 도서 리스트 \r\n");
		}
		pw.close();
		
		//PrintWriter를 이용하여 추가하려면..
		//파일 객체를 생성해서 추가
		PrintWriter pw2 = new PrintWriter(new FileWriter("booklist.txt",true));
		for(int i=11; i<=20; i++) {
			String data = i+ " 번째 도서 \r\n"; 
			pw2.write(data); //기록
			pw2.write("내 도서 리스트 \r\n");
		}
		pw2.close();
		
		//바이트기반 스트림
		//FileOutputStream을 이용한 파일 쓰기
		FileOutputStream output = new FileOutputStream("out.txt");
		for(int i=1; i<=10; i++) {
			String data = i+"Test mode \r\n";
			//바이트 기반 스트림이기 때문에 바이트 단위로 쓰기
			output.write(data.getBytes());
		}
		output.close();
	}
}