package thread;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThreadOnOff extends JFrame implements Runnable {
	private JLabel label;
	private JButton btn;
	private int count;
	private boolean onoff;

	public ThreadOnOff() {
		label = new JLabel("0", JLabel.CENTER);
		label.setFont(new Font("���ü", Font.BOLD, 70));
		label.setForeground(Color.BLUE);
		btn = new JButton("������");

		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(btn);

		add("Center", label);
		add("South", p);

		setBounds(700, 200, 300, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// thread����
		

		// �̺�Ʈ ����
		btn.addMouseListener(new MouseAdapter() {
			Thread t;
			@Override
			public void mousePressed(MouseEvent e) {
				
				t = new Thread(ThreadOnOff.this);// thread����
				t.start();
				System.out.println("������ t = "+t);
				onoff = true;
			
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				t=null;
				System.out.println("���� t = "+t);
				onoff = false;
			}

		});
	}

	@Override
	public void run() {
	
		while(true) {
			count++;
			label.setText(count+"");
			
			if(!onoff )break;   //if���� false�� �����̿��� if���� �������� �ȵ��⶧���� !ǥ�� �ٲ��༭ ����
				
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(count==50)count=0;
		}

	}

	public static void main(String[] args) {
		new ThreadOnOff();
	}

}