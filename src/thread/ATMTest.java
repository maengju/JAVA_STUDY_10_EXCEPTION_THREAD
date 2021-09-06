package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATMTest implements Runnable {

	private long depsiteMoney = 100000;// �ܾ�
	private long balance; // ã�����ϴ� �ݾ�

	@Override
	public synchronized void run() {

		System.out.println("�ȳ��ϼ��� " + Thread.currentThread().getName() + "");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("ã���� �ϴ� �ݾ� �Է� : ");

		try {
			balance = Long.parseLong(br.readLine());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();

		// �ܾ� ���
		if (balance > depsiteMoney) {
			System.out.println("�ܾ׺����մϴ�. ");

		} else if (balance % 10000 != 0) {
			System.out.println("���������� �Է��� �ּ��� ");
		} else {
			depsiteMoney -= balance;
			System.out.println("�ܾ��� " + depsiteMoney + " �Դϴ�.");
		}

	}// run

	public static void main(String[] args) {
		ATMTest at = new ATMTest();
		Thread mom = new Thread(at, "����"); // mom.setName�� ���ų� �̷��� �̸� ���� ����
		Thread son = new Thread(at, "�Ƶ�");
		mom.start();
		son.start();

	}

}
