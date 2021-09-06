package thread;

class JoinTest implements Runnable{

	@Override
	public void run() {
		for(int i = 1; i<=5; i++) {
			System.out.println("i = "+i);
		}
		
	}
	
	
	
}

//==============================================================================
public class JoinMain {

	
	
	
	public static void main(String[] args) {
		
		JoinTest jt = new JoinTest(); 
		Thread t = new Thread(jt); //jt를 thread로 생성
		
		System.out.println("thread 시작");
		t.start();//스레드 시작-운영체제의 의해 실행 (run())
		try {
			t.join(); //스레드를 다 끝내고 멈추게 하는명령어
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread 종료");
		
	}
	
	//메인 메소드가 끝나도 스레드는 종료되지 않는다.
	//메인 메소드가 종료되어도 백그라운드에서 스레드는 돌아간다.
	
	
	
	
	
}
