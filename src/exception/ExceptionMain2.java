package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionMain2 {
	private int dan;

	public void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.print("���ϴ� �� �Է� : ");
			dan = Integer.parseInt(br.readLine());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}// input

	public void output() {

		int i;
		if (dan >= 2 && dan <= 9) {
			for (i = 1; i < 10; i++) {
				System.out.printf("%d * %d = %d\n", dan, i, dan * i);
			}
		}else {//System.out.println("2~9������ ���ڸ� �Է�");
			
			try {
			//������ Exception�߻�
			throw new MakeException("2~9������ ���ڸ� �Է�");
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		
		}
	}// output

	public static void main(String[] args) {
		ExceptionMain2 exm = new ExceptionMain2();
		exm.input();
		exm.output();

	}

}
