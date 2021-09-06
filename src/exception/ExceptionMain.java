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
		System.out.println("정수 입력 : ");
		a = Integer.parseInt(br.readLine());
		
		System.out.println("정수 입력 : ");
		b = Integer.parseInt(br.readLine());
		
		System.out.printf("%d / %d = %d",a,b,a/b);
		
		}catch(IOException e){
			e.printStackTrace();
		}catch(NumberFormatException e) {
			System.out.println("숫자 형태만 입력");
			e.printStackTrace();
		}catch(ArithmeticException e) {
			System.out.println("0으로 나누지마시오");
			e.printStackTrace();
		}
		finally {
			System.out.println("무조건 수행");
		}
		
		
		
		
	}
	
	
	private void sub() {
		System.out.println("hohoho");

	}
	
	
	
}
