package thread;

class SnackTest extends Thread {
	private String str;
	
	public SnackTest(String str) {
		this.str = str;
	}
	
	public void run() {
		for(int i = 1; i<=5; i++) {
			System.out.println(str+"\t"+"i = "+i +"\t"+ Thread.currentThread()); // Thread.currentThread �ּ� ������ �ϴ°�
		}
	}
	
	
	
	
	
}


//=================================================================================================================================

public class SnackMain {

	public static void main(String[] args) {

		SnackTest aa = new SnackTest("�����");
		SnackTest bb = new SnackTest("��īĨ");
		SnackTest cc = new SnackTest("Ȩ����");

		
		//�����忡 �̸��ο�
		aa.setName("�����");
		bb.setName("��īĨ");
		cc.setName("Ȩ����");

		//�켱���� - 1~10 (defult : 5)
//		aa.setPriority(10);//aa.setPriority(Thread.MAX_PRIORITY);
//		bb.setPriority(Thread.MIN_PRIORITY); //1
//		cc.setPriority(Thread.NORM_PRIORITY); //5
		
		aa.start(); // thread start -> ������ ���� (run())
		
		try {
			aa.join();// thread ���̱�
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		bb.start(); // thread start -> ������ ���� (run())
		cc.start(); // thread start -> ������ ���� (run())
	}

}
