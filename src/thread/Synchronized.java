package thread;

public class Synchronized extends Thread {
	private static int count;
	
	public Synchronized() {

		System.out.println("this = "+this);
	
	}

	public static void main(String[] args) {
		Synchronized aa = new Synchronized(); // thread생성
		Synchronized bb = new Synchronized();
		Synchronized cc = new Synchronized();

		aa.setName("aa");
		bb.setName("bb");
		cc.setName("cc");
		aa.start();
		bb.start();
		cc.start();
	}

	@Override
	// public synchronized void run() { 동기화가 안된 상태 스레드를 따로 잡앗기때문에 이렇게됨
	public void run() {
		synchronized (Synchronized.class) { // 스레드를 각자 잡았을때는 공통점을 찾아서  잡아줘야된다.

			for (int i = 1; i <= 5; i++) {
				count++;
				System.out.println(Thread.currentThread().getName() + " : count =" + count);
			}
		}
	}

}
