package day06;

public class ArrayCopy {

	public static void main(String[] args) {
		
		int arr[]=new int[] {1,2,3,4};
		int arr1[] = arr;	//copy
		int arr2[] = new int[5];
//		System.out.println(arr);	//주소가 같음
//		System.out.println(arr1);	//주소가 같음
//		System.out.println(arr2);
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		for(int i=0; i<arr2.length; i++) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
		//	arr의 값을 arr2로 복사
		for(int i=0; i<arr.length; i++) {
			arr2[i+1]= arr[i];
		}
		for(int i=0; i<arr2.length; i++) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
		
		//arr를 arr3으로 복사
		//arr3은 10개의 데이터를 담을 수 있는 배열로 생성
		int arr3[] = new int [10];
		for(int i=0; i<arr.length; i++) {
			arr3[i]= arr[i];
		}
		for(int i : arr3) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		//System.arraycopy (이전배열, 시작번지, 새배열, 시작번지, 개수);
		int[] arr4 = new int[10];
		System.arraycopy(arr, 0, arr4, 2, arr.length);
		for(int i : arr4) {
			System.out.print(i+" ");
		}
	}
}