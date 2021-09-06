package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATMTest implements Runnable {

	private long depsiteMoney = 100000;// 잔액
	private long balance; // 찾고자하는 금액

	@Override
	public synchronized void run() {

		System.out.println("안녕하세요 " + Thread.currentThread().getName() + "");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("찾고자 하는 금액 입력 : ");

		try {
			balance = Long.parseLong(br.readLine());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();

		// 잔액 계산
		if (balance > depsiteMoney) {
			System.out.println("잔액부족합니다. ");

		} else if (balance % 10000 != 0) {
			System.out.println("만원단위로 입력해 주세요 ");
		} else {
			depsiteMoney -= balance;
			System.out.println("잔액은 " + depsiteMoney + " 입니다.");
		}

	}// run

	public static void main(String[] args) {
		ATMTest at = new ATMTest();
		Thread mom = new Thread(at, "엄마"); // mom.setName을 쓰거나 이렇게 이름 지정 가능
		Thread son = new Thread(at, "아들");
		mom.start();
		son.start();

	}

}
