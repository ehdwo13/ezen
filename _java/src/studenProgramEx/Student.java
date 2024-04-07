package studenProgramEx;

public class Student {
	private String stdNum;
	private String stdName;
	private String stdPhone;
	
	private Subject [] subjectList = new Subject[5];
	private int count;
	
	public Student() {}
	public Student(String stdNum, String stdName, String stdPhone) {
		this.stdNum=stdNum;
		this.stdName=stdName;
		this.stdPhone=stdPhone;
	}
	public void stdPrint() {
		System.out.println("학생명 : "+stdName+"("+stdNum+") /"+stdPhone);
	}
	public void subPrint() {
		if(count==0) {
			System.out.println("수강중인 과목이 없습니다. ");
			return;
		}
		for(int i=0; i<count; i++) {
			System.out.println(subjectList[i]);
		}
	}
	public void insertSubject(Subject sub) {
		//배열이 다 찼다면 배열을 늘려주기
		//배열은 길이를 정하면 변경불가능
		//더 긴 길이의 배열을 생성하여 배열 복사 후 배열 바꾸기
		if(count==subjectList.length) {
			Subject [] tmp = new Subject[subjectList.length+5];
			//배열복사
			System.arraycopy(subjectList, 0, tmp, 0, count);
			subjectList = tmp;
		}
		subjectList[count]=sub;
		count++;
	}
	public void deleteSubject(String subName) {
		int index = -1;
		if(subName == null) {
			return;
		}
		for(int i=0; i<count; i++) {
			if(subjectList[i].getSubName().equals(subName)) {
				index = i;
				break;
			}
		}
		if(index==-1) {
			System.out.println("찾는 과목이 없습니다. ");
			return;
		}
		for(int i=index; i<count-1; i++) {
			subjectList[i]=subjectList[i+1];
		}
		subjectList[count-1]=null;
		count--;
	}
	public String getStdNum() {
		return stdNum;
	}
	public void setStdNum(String stdNum) {
		this.stdNum = stdNum;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdPhone() {
		return stdPhone;
	}
	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}
	public Subject[] getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(Subject[] subjectList) {
		this.subjectList = subjectList;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Student [stdNum=" + stdNum + ", stdName=" + stdName + ", stdPhone=" + stdPhone + "]";
	}
}
