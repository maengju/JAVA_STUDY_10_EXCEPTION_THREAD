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
		Thread t = new Thread(jt); //jt�� thread�� ����
		
		System.out.println("thread ����");
		t.start();//������ ����-�ü���� ���� ���� (run())
		try {
			t.join(); //�����带 �� ������ ���߰� �ϴ¸�ɾ�
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread ����");
		
	}
	
	//���� �޼ҵ尡 ������ ������� ������� �ʴ´�.
	//���� �޼ҵ尡 ����Ǿ ��׶��忡�� ������� ���ư���.
	
	
	
	
	
}
