package domain;

public class MemberVO {
	private String id;
	private String password;
	private String email;
	private int age;
	private String regdate;
	private String lastlogin;
	
	public MemberVO() {}
	
	//로그인 생성자
	public MemberVO(String id, String password) {
		this.id = id;
		this.password = password;
	}
	//회원가입 생성자
	public MemberVO(String id, String password, String email, int age) {
		this(id,password);
		this.email = email;
		this.age = age;
	}
	//전체출력 생성자
	public MemberVO(String id, String password, String email, int age, String regdate, String lastlogin) {
		this(id,password,email,age);
		this.regdate = regdate;
		this.lastlogin = lastlogin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", email=" + email + ", age=" + age + ", regdate="
				+ regdate + ", lastlogin=" + lastlogin + "]";
	}
}
