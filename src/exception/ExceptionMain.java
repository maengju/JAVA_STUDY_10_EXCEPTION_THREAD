package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class ExceptionMain {
	
	
	public static void main(String[] args)  {

		if(args.length >= 1 )
		System.out.println("args[0] : "+args[0]);
		
		ExceptionMain em = new ExceptionMain();
		em.sub();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int a,b ;
		
		try {
		System.out.println("���� �Է� : ");
		a = Integer.parseInt(br.readLine());
		
		System.out.println("���� �Է� : ");
		b = Integer.parseInt(br.readLine());
		
		System.out.printf("%d / %d = %d",a,b,a/b);
		
		}catch(IOException e){
			e.printStackTrace();
		}catch(NumberFormatException e) {
			System.out.println("���� ���¸� �Է�");
			e.printStackTrace();
		}catch(ArithmeticException e) {
			System.out.println("0���� ���������ÿ�");
			e.printStackTrace();
		}
		finally {
			System.out.println("������ ����");
		}
		
		
		
		
	}
	
	
	private void sub() {
		System.out.println("hohoho");

	}
	
	
	
}
