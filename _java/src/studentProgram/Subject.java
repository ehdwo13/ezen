package studentProgram;

public class Subject {
	private int code;			//과목코드
	private String subjectName;	//과목명
	private int score;			//학점
	private int time;			//시수
	private String teacherName;	//교수명
	private String semester;	//학기
	private String timeTable;	//시간표
	private String location;	//강의장

	public Subject() {}	
	
	public Subject(int code, String subjectName) {
		this.code = code;
		this.subjectName = subjectName;
	}
	
	public Subject(int code, String subjectName, int score, int time, String teacherName, String semester,
			String timeTable, String location) {
		super();
		this.code = code;
		this.subjectName = subjectName;
		this.score = score;
		this.time = time;
		this.teacherName = teacherName;
		this.semester = semester;
		this.timeTable = timeTable;
		this.location = location;
	}
	//toString
	@Override
	public String toString() {
		return "code=" + code + ", subjectName=" + subjectName + ", score=" + score + ", time=" + time
				+ ", teacherName=" + teacherName + ", semester=" + semester + ", timeTable=" + timeTable + ", location="
				+ location;
	}
	//getter/setter
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getTimeTable() {
		return timeTable;
	}
	public void setTimeTable(String timeTable) {
		this.timeTable = timeTable;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}