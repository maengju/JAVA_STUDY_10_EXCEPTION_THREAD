package thread;

public class Synchronized extends Thread {
	private static int count;
	
	public Synchronized() {

		System.out.println("this = "+this);
	
	}

	public static void main(String[] args) {
		Synchronized aa = new Synchronized(); // thread����
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
	// public synchronized void run() { ����ȭ�� �ȵ� ���� �����带 ���� ��ѱ⶧���� �̷��Ե�
	public void run() {
		synchronized (Synchronized.class) { // �����带 ���� ��������� �������� ã�Ƽ�  �����ߵȴ�.

			for (int i = 1; i <= 5; i++) {
				count++;
				System.out.println(Thread.currentThread().getName() + " : count =" + count);
			}
		}
	}

}
