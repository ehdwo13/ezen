package BoardT;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class BoardT {
	/*	번호, 제목, 내용, 작성자, 작성일
	 * 	번호가 일치하면 같은 게시물 인지 equals 추가
	 *  - 객체는 독립적 / 각 객체가 하나의 번호를 참고
	 *  번호는 자동증가 => static
	 *  작성일은 오늘날짜 자동으로 추가
	 * */
	
	private static int count;
	private int num;
	private String title;
	private String content;
	private String writer;
	private String registerDate;
	
	//생성자
	public BoardT() {
		count++;
		num = count;
		Date register = new Date();
		SimpleDateFormat sh = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		this.registerDate = sh.format(register);
	}
	
	public BoardT(String title, String content, String writer) {
		this();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	//번호만 가지는 객체 생성
	//번호가 일치하면 같은 게시물 인지 equals 추가
	public BoardT(int num) {
		this.num = num;
	}
	
	//getter/setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	
	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "Board [num=" + num + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", registerDate=" + registerDate + "]";
	}
	public void print() {
		//하나의 게시글을 예쁘게 보여주는 메서드
		System.out.println("번호 : "+getNum());
		System.out.println("제목 : "+getTitle());
		System.out.println("작성자 : "+getWriter());
		System.out.println("작성일 : "+getRegisterDate());
		System.out.println("내용 : ");
		System.out.println(getContent());
	}
	@Override
	public int hashCode() {
		return Objects.hash(num,title,content,writer,registerDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardT other = (BoardT) obj;
		return num == other.num;
	}
}