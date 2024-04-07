package day04;

public class For07 {

	public static void main(String[] args) {
		//	이중 For문
//		for(int i=1; i<=5; i++) {		//	i = 1		2		3		4		5
//			for(int j=1; j<=5; j++)		//	j = 1~5		1~5		1~5		1~5		1~5
//				System.out.print(i);	//  총 25번 실행
//		}
		// 별찍기
		/*	*****
		 *  *****
		 *  *****
		 *  *****
		 *  *****
		 * */
		for(int i=1; i<=5; i++) {		
			for(int j=1; j<=5; j++) {
				System.out.print("*");
			}
			System.out.println();	//한 줄 끝나면 줄바꿈
			}
		
		System.out.println("----------");
		
		/*	*
		 *  **
		 *  ***
		 *  ****
		 *  *****
		 * */
		for(int i=1; i<=5; i++) {		
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
			}
		System.out.println("----------");
		
		/*	*****
		 * 	****
		 * 	***
		 * 	**
		 * 	*
		 * */
		
		for(int i=1; i<=5; i++) {		
			for(int j=5; j>=i; j--) {
				System.out.print("*");
			}
			System.out.println();
			}
		System.out.println("----------");
		
		/*	    *	i=1, 공백=4, j=1
		 * 	   **	i=2, 공백=3, j=2
		 * 	  ***	i=3, 공백=2, j=3
		 *   ****	i=4 j=4
		 *  *****	i=5 j=5
		 * */
			
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5-i; j++) {		//공백
				System.out.print(" ");
			}
			for(int k=1; k<=i; k++) {	//별출력
				System.out.print("*");
			}
			System.out.println();
			}
	
		System.out.println("----------");
		/*		*			i=1 공백=8 j=1 
		 *     ***			i=2 공백=5 j=3
		 *    *****			i=3	공백=3 j=5
		 *   *******		i=4 공백=1 j=7
		 *  *********		i=5 공백=0 j=9
		 *
		 **/
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5-i; j++) {
				System.out.print(" ");
			}
			for(int k=1; k<=i*2-1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("----------");
		/* 123 
		 * 456
		 * 789
		 * */
		int num = 0;
		for(int i=1; i<=3; i++) {		
			for(int j=1; j<=3; j++) {
				num++;
				System.out.print(num+" ");
			}
			System.out.println();	
		}	
//				if (i==1){
//					System.out.print(j+" ");
//				}else if(i==2) {
//					System.out.print(j+3+" ");
//				}else {
//					System.out.print(j+6+" ");
	}
}
