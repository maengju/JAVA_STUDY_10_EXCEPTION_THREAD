package thread;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Clock extends JFrame implements Runnable {

	private JLabel timeL;
	
	public Clock() {

		timeL = new JLabel("",JLabel.CENTER);
		
		
		timeL.setFont(new Font("Arial", Font.BOLD, 36));
		timeL.setForeground(Color.GRAY);
		
		setTitle("시계는 영어로 클록");

		add("Center",timeL);
		
		setBounds(300, 150, 400, 150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // JFrame에서 종료 하는 법

		Thread t = new Thread(this);// 스레드 생성
		t.start();// thread시작
	}

	
	@Override
	public void run() {

		while (true) {
			repaint();// paint() 호출
			
			try {
				Thread.sleep(1000);// 단위 1/1000초
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} 
			
		} // while

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Calendar cal = Calendar.getInstance();

		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);

		String time = String.format("%02d : %02d : %02d", hour, minute, second);
		timeL.setText(time);

	}
	
	

	public static void main(String[] args) {

		new Clock();

	}

}
