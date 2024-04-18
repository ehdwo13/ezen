package domain;

public class MemberVO {
	private String id;
	private String pwd;
	private String email;
	private int age;
	private String phone;
	private String regdate;
	private String lastLogin;
	
	public MemberVO() {}
	
	//로그인 생성자
	public MemberVO(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	//회원가입 생성자
	public MemberVO(String id, String pwd, String email, int age, String phone) {
		this(id,pwd);
		this.email = email;
		this.age = age;
		this.phone = phone;
	}
	//전체 출력
	public MemberVO(String id, String pwd, String email, int age, String phone, String regdate, String lastLogin) {
		this(id,pwd,email,age,phone);
		this.regdate = regdate;
		this.lastLogin = lastLogin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", email=" + email + ", age=" + age + ", phone=" + phone
				+ ", regdate=" + regdate + ", lastLogin=" + lastLogin + "]";
	}
}