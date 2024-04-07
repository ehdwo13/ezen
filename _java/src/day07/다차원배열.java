package day07;

public class 다차원배열 {

	public static void main(String[] args) {
		/*	2차원 배열
		 * 	10 20 30 
		 * 	60 40 80 
		 * 	30 80 10
		 *  20 40 10
		 *  50 80 10
		 * 	자료형 배열명 [][] = new 자료형[5][3];	//5행 3열
		 * 
		 * */
		int arr[][] = new int[5][3];
		
		int count = 1;
		for (int i=0; i<arr.length; i++) {		//0번지부터 4번지까지 5개행 반복
			for(int j=0; j<arr[0].length; j++) {
				arr[i][j] = count ;
				count ++;
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}