package thread;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RunRace extends JFrame implements ActionListener{
	private int count;
	private JButton startBtn;
	private Racer[] racer;
	int rank=1;
	
	public RunRace(int count) {
		startBtn = new JButton("START");
		
		
		JPanel southP = new JPanel(new FlowLayout(FlowLayout.RIGHT));  // defult�� ���, ���������� �ű�� ���
		southP.add(startBtn);
		
		this.add("South", southP);
		
		Scanner scan = new Scanner(System.in);
		
		JPanel centerP = new JPanel(new GridLayout(count,1)); // flowlayout�� �⺻������ 
		
		String horseName = null;
		racer = new Racer[count];
		for (int i = 0 ; i< count; i++) {
			System.out.print("�� �̸� �Է� : ");
			horseName = scan.next();
			
			racer[i] = new Racer(horseName);
			centerP.add(racer[i]);
		}
		
		
		
		
		this.add("Center",centerP);
		this.count = count;
		
		setBounds(400,150,700,500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//event
		startBtn.addActionListener(this);
		
		
	}//������
	
	public RunRace() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		startBtn.setEnabled(false);
		Thread[] t = new Thread[count];
		for(int i = 0; i<count; i++) {
			t[i] = new Thread(racer[i]); // thread����
			
			//�켱�����ο�  1~10
			int num = (int)(Math.random()*10)+1;
			t[i].setPriority(num);
			
			t[i].start(); //������ ����
			
			
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
	}

	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("�� ���� �� �Է�  :  ");
		int count = scan.nextInt();
		
		new RunRace(count);
		
	}

	

}
