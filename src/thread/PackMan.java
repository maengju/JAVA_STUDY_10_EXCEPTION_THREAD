/*
 ���� ũ�� 20,20
 
 ���̴� �����ϰ� 5�� ����ֱ� 
 int[] foodX,foodY;
  
 
 */

package thread;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class PackMan extends Frame implements KeyListener, Runnable {
	private Image img, starimg;
	private int select = 0;
	private int x = 225, y = 225, mx, my;
	private int[] foodX, foodY;
	private int count;

	// ������
	public PackMan() {

		img = Toolkit.getDefaultToolkit().getImage("image/packman.png");
		starimg = Toolkit.getDefaultToolkit().getImage("image/bulestar.png");

		foodX = new int[5];
		foodY = new int[5];

		for (int i = 0; i < foodX.length; i++) {
			foodX[i] = (int) ((Math.random() * 421) + 40);
			foodY[i] = (int) ((Math.random() * 421) + 40);

			System.out.println(foodX[i]+","+foodY[i]);
		}

		setBounds(400, 150, 500, 500);
		setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		// event

		this.addKeyListener(this);// add�տ� �̺�Ʈ�� �Ͼ�°�()�ȿ� ������
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				super.windowClosing(e);
			}
		});

		// thread����
		Thread t = new Thread(this);
		t.start();

	}// packman

	@Override
	public void paint(Graphics g) {

		super.paint(g);
		for (int i = 0; i < foodX.length; i++) {
			g.drawImage(starimg, foodX[i], foodY[i], 20, 20, this);

		}

		g.drawImage(img, x, y, x + 50, y + 50, // ȭ����ġ
				select * 50, 0, (select * 50) + 50, 50, // �̹��� ��ġ
				this); // �׸� �߶� �׸���

	}// paint

	@Override
	public void run() { // ���� ���̵�� �޼ҵ�� throws�� �ȸ����� try/cath�� ����

		while (true) {
			repaint();

			if (select % 2 == 0) {
				select++; //���� �ٹ���
			} else
				select--; // ���� �����ִ°�

			//��ǥ�̵�
			x = x + mx;
			y = y + my;

			
			//���� 
			for (int i = 0; i < foodX.length; i++) {
				if (foodX[i] + 30 > (x + 25) && foodX[i]-10 <= (x + 25))
						{
					if (foodY[i] + 30 > (y + 25) && foodY[i]-10 < (y + 25)){
						foodX[i] = -100;
						foodY[i] = -100;
						count++;
						if(count!=5) {
						System.out.println((5-count)+"�� ���ҽ��ϴ�.");
						}
						
					}
				}
			}
			if(count==5) {
				x=225; y=255;
				select = 1;
				System.out.println("���� ����!");
				break;
			}
			
			
			if (x > 500) {
				x = 0;
			} else if (x < 0) {
				x = 500;
			} else if (y > 500) {
				y = 0;
			} else if (y < 0) {
				y = 500;
			}

			try {
				Thread.sleep(100); // ���� 1/1000��
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // while

	}// run

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) { // getKeyCode ���� �ҷ����°�
			select = 0;
			mx = -10;
			my = 0;

		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			select = 2;
			mx = 10;
			my = 0;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			select = 4;
			mx = 0;
			my = -10;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			select = 6;
			mx = 0;
			my = 10;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

//===========================================================main
	public static void main(String[] args) {

		new PackMan();
	}// main

}
