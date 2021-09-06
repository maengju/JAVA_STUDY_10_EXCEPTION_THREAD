package thread;

class SnackTest extends Thread {
	private String str;
	
	public SnackTest(String str) {
		this.str = str;
	}
	
	public void run() {
		for(int i = 1; i<=5; i++) {
			System.out.println(str+"\t"+"i = "+i +"\t"+ Thread.currentThread()); // Thread.currentThread 주소 나오게 하는것
		}
	}
	
	
	
	
	
}


//=================================================================================================================================

public class SnackMain {

	public static void main(String[] args) {

		SnackTest aa = new SnackTest("새우깡");
		SnackTest bb = new SnackTest("포카칩");
		SnackTest cc = new SnackTest("홈런불");

		
		//스레드에 이름부여
		aa.setName("새우깡");
		bb.setName("포카칩");
		cc.setName("홈런불");

		//우선순위 - 1~10 (defult : 5)
//		aa.setPriority(10);//aa.setPriority(Thread.MAX_PRIORITY);
//		bb.setPriority(Thread.MIN_PRIORITY); //1
//		cc.setPriority(Thread.NORM_PRIORITY); //5
		
		aa.start(); // thread start -> 스레드 실행 (run())
		
		try {
			aa.join();// thread 죽이기
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		bb.start(); // thread start -> 스레드 실행 (run())
		cc.start(); // thread start -> 스레드 실행 (run())
	}

}
