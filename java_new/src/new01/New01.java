package new01;

public class New01 {

	public static void main(String[] args) {
		/*	홍길동 주민등록번호 881122-1234567이다.
		 * 	출력형태 => 생년원일 : 881122, 성별 : 남 (1,3)
		 * 	콘솔에 출력
		 * */
		String reg = "881122-1234567";
		String birth = reg.substring(0,reg.indexOf("-"));
		String gender = reg.substring(reg.indexOf("-")+1,8);
		if(gender.equals("1") || gender.equals("3")) {
			System.out.println("생년월일 : "+birth+ ", 성별 : "+"남");
		}else{
			System.out.println("생년월일 : "+birth+ ", 성별 : "+"여");
		}
	}
}
