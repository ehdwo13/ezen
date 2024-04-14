package day22;

class MyThread01 extends Thread{
	int sum;
	int start;
	int end;
	public MyThread01(int start, int end) {
		this.start=start;
		this.end=end;
	}
	@Override
	public void run() {
		for(int i=start; i<=end; i++) {
			sum+=i;
		}
		System.out.println(sum);
	}
}

public class Thread03 {

	public static void main(String[] args) {
		//	1~50까지 51~100까지 합을 구하는 두개의 Thread를 생성
		// 	그 결과를 확인
		
		//두개의 Thread가 실행되고 난 후
		//Thread1 1~50까지의 합계 출력
		//Thread2 51~100까지의 합계 출력
		//thread1+thread2의 합계 출력
		
		MyThread01 mth = new MyThread01(1,50);
		MyThread01 mth1 = new MyThread01(51,100);
		mth.start();
		mth1.start();
		try {
			mth.join();
			Thread.sleep(500);		//0.5초 기다렸다가 실행
			mth1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(mth.sum+mth1.sum);
	}

}
