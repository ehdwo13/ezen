package day16;

public class Exception06 {

	public static void main(String[] args) throws Exception{
		//메서드에서 생성된 배열 출력
		int start = 1, count =-5, size = 3;
		int arr[] = null;
		try {
			arrList(size, count, start);
			fillArr(arr, start, count);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//메서드 생성
	/*	기능 : size를 매개변수로 입력받아 size만큼의 길이를 가지는 배열을 생성하여
	 * 	랜덤값을 채워 배열을 리턴
	 * 	랜덤값의 범위는 매개변수 입력 start(시작값), count(개수)
	 * 
	 * 	- size가 0보다 작다면 예외발생 
	 * 	- count 개수가 0보다 작다면 예외발생
	 * */
	public static int[] arrList(int size, int count, int start){
		if(count<0) {
			throw new RuntimeException("개수는 0보다 작을 수 없습니다. ");
		}
		if(size<=0) {
			throw new RuntimeException("배열의 길이는 0보다 작을 수 없습니다. ");
		}
		int randomArr[]=new int[size];
			for(int i=0; i<size; i++) {
			randomArr[i]=(int)(Math.random()*count)+start;
			}
		
	return randomArr;
	}
	//메서드 생성
	/*	기능 : 매개변수로 배열을 받아서 랜덤값을 채우는 메서드
	 *  랜덤값의 범위는 매개변수 입력 start, count
	 *  - 배열이 null이면 예외발생
	 *  - 배열의 길이가 0보다 작으면 예외발생
	 * */
	public static void fillArr(int arr[],int start, int count) {
		if(arr==null) {
			throw new RuntimeException("배열이 null 입니다. ");
		}
		if(arr.length<0) {
			throw new RuntimeException("길이가 0보다 작습니다. ");
		}
			
		for(int i=0; i<arr.length; i++) {
			arr[i]=(int)(Math.random()*count)+start;
		}
	}
}