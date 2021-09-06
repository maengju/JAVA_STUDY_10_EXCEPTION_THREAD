package thread;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Timer extends JFrame implements ActionListener, Runnable {
	private JLabel label;
	private JButton startBtn, stopBtn;
	private boolean onoff;
	private int count;

	public Timer() {
		label = new JLabel("0", JLabel.CENTER);
		label.setFont(new Font("고딕체", Font.BOLD, 70));

		startBtn = new JButton("시작");
		stopBtn = new JButton("멈춤");

		JPanel p = new JPanel(new GridLayout(2, 1, 0, 10));
		p.add(startBtn);
		p.add(stopBtn);

		add("Center", label);
		add("East", p);

		setTitle("Timer");
		setBounds(700, 300, 300, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 이벤트
		startBtn.addActionListener(this);
		stopBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = null;

		if (e.getSource() == startBtn) {// 시작 버튼
			t = new Thread(this); // 스레드 생성
			t.start(); // 스레드 시작

			onoff = true;

			startBtn.setEnabled(false);
			stopBtn.setEnabled(true);

		} else if (e.getSource() == stopBtn) {// 멈춤 버튼
			t = null;

			onoff = false;

			startBtn.setEnabled(true);
			stopBtn.setEnabled(false);
		}
	}

	@Override
	public void run() {
		int i;

		for (i = count; i <= 50; i++) {
			label.setText(i + "");

			if (!onoff) {
				count = i;
				break;
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // for

		if (i >= 50) {
			count = 0;

			startBtn.setEnabled(true);
			stopBtn.setEnabled(false);
		}
	}

	public static void main(String[] args) {
		new Timer();
	}

}