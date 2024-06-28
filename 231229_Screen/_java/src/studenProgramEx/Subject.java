package studenProgramEx;

public class Subject {
	private String subName;			//과목명
	private int subTime;			//시수
	private String subprofessor;	//담당교수
	private String subSchduler;		//시간표
	
	public Subject() {}
	public Subject(String subName) {
		this.subName=subName;
	}
	public Subject(String subName, int subTime, String subprofessor, String subSchduler) {
		this.subName = subName;
		this.subTime = subTime;
		this.subprofessor = subprofessor;
		this.subSchduler = subSchduler;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public int getSubTime() {
		return subTime;
	}
	public void setSubTime(int subTime) {
		this.subTime = subTime;
	}
	public String getSubprofessor() {
		return subprofessor;
	}
	public void setSubprofessor(String subprofessor) {
		this.subprofessor = subprofessor;
	}
	public String getSubSchduler() {
		return subSchduler;
	}
	public void setSubSchduler(String subSchduler) {
		this.subSchduler = subSchduler;
	}
	@Override
	public String toString() {
		return "과목명 : " + subName + ", 시수 : " + subTime + ", 담당교수 : " + subprofessor
				+ ", 시간표 : " + subSchduler;
	}
}