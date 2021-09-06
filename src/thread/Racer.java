package thread;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

//말 1마리
public class Racer extends Canvas implements Runnable{
	private Image img ;
	private String horseName;
	static int rank;
	
	int pos;
	
	
	public Racer(String horseName) {
		this.horseName=horseName;
		
		img = Toolkit.getDefaultToolkit().getImage("image/mal.gif");
		
		
		
	
	}
	@Override
	public void run() {
		int i;
		for( i= 0 ; i<650; i+=((int)(Math.random()*10)+1)) {
			pos=i;
			repaint();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}//for
		
	
		
		//등수
		if(i>=650) {
			System.out.println(horseName + "의 등수는 "+(rank+1)+"등 입니다.");
			rank++;
			}
		
		
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img, pos, 0,25,this.getSize().height, this);
		g.drawLine(0, this.getSize().height, this.getSize().width, this.getSize().height);
		
	
	}



	
	
}
