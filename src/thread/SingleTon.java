package thread;

public class SingleTon {
	private int num = 3;
	private static SingleTon instance = null; // 초기화, 1번

	public static SingleTon getInstance() {
		if (instance == null) {
			synchronized (SingleTon.class) { //웹일 경우 싱크로로 잡아줘야댐 
				instance = new SingleTon();
			}
		}

		return instance;

	}// getInstance

	public static void main(String[] args) {

		SingleTon aa = new SingleTon();
		aa.num++;
		System.out.println("aa = " + aa);
		System.out.println("num = " + aa.num);
		System.out.println();

		SingleTon bb = new SingleTon();
		bb.num++;
		System.out.println("bb = " + bb);
		System.out.println("num = " + bb.num);
		System.out.println();

		System.out.println("-----singleTon-----");
		System.out.println();
		SingleTon cc = SingleTon.getInstance();
		cc.num++;
		System.out.println("cc = " + cc);
		System.out.println("num = " + cc.num);
		System.out.println();

		SingleTon dd = SingleTon.getInstance();
		dd.num++;
		System.out.println("dd = " + dd);
		System.out.println("num = " + dd.num);
		System.out.println();

	}

}
