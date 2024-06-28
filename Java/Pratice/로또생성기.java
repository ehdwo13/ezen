package Pratice;

public class 로또생성기 {

	public static void main(String[] args) {
		/*	로또 번호 생성
		 * */
		int com[] = new int[7];		//당첨번호
		int user[] = new int[6];	//사용자 로또 번호
		lotto(com);
		printArray(com);
		lotto(user);
		printArray(user);
		checkLotto(com, user);
	}
	/*	배열을 매개변수로 받아 1~45까지 랜덤수를 채워서 생성.
	 * 	같은 수 나오면 안됨
	 * */
	public static int[] lotto(int arr[]) {
		int index = 0;		//배열인덱스번호
		while (true) { 
			int num = (int) (Math.random()*10+1);
			for (int i = 0; i < arr.length; i++) {
				if (check(arr, num)==false) {
					break; 
				}
			}
			if (check(arr, num)==true) {
				arr[index] = num;
				index++; 
			}
			if (index == arr.length) {
				break;
			}
		}
		return arr;
	}	
	/*	배열을 매개변수로 받아 배열을 출력하는 매서드
	 * 	마지막 번호는 보너스번호로 출력
	 * */
	public static void printArray(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			if(i>=6) {
				System.out.print("["+arr[i]+"]");
			}else {
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
	}
	/*	배열에 중복이 있는지 확인
	 * 	매개변수 : 배열, 값
	 * 	있으면 true 없으면 false
	 * */
	public static boolean check(int arr[],int num){
			boolean result = true;
			for(int i=0; i<arr.length; i++) {
				if(arr[i]==num) {
					result = false;
				}
			}return result;
	}
	/*	당첨번호와 내번호 비교 후 맞는 개수 체크 
	 * */
	public static void checkLotto(int arr[], int arr1[]) {
		int count = 0;
		int rank = 0;
		int bonus = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr1.length; j++) {
				if(arr[i]==arr1[j]) {
					count ++;
					}
				if(i==6) {
					arr[i]=bonus;
				}
			}
		}
		switch(count) {
		case 6 : rank = 1;
			System.out.println(count+"개 맞추셨습니다. "+rank+"등입니다. ");
		break;
		case 5 : if(check(arr1, bonus)) {
					rank =2;
					System.out.println(count+"개와 보너스 번호를 맞추셨습니다. \n"+rank+"등입니다. ");
				}else {
					rank =3;
					System.out.println(count+"개를 맞추셨습니다. "+rank+"등입니다. ");
				}
		break;
		case 4 : rank = 4;
			System.out.println(count+"개 맞추셨습니다. "+rank+"등입니다. ");
		break;
		case 3 : rank = 5;
			System.out.println(count+"개 맞추셨습니다. "+rank+"등입니다. ");
		break;
		default :
			System.out.println("꽝입니다.");
		}
	}
}