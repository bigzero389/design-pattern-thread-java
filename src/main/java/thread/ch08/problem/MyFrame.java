package thread.ch08.problem;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class MyFrame extends JFrame implements ActionListener {
	private final JLabel label = new JLabel("Event Dispatching Thread Sample");
	private final JButton button = new JButton ("countUp");
	
	public MyFrame() {
		super("MyFrame");
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(label);
		getContentPane().add(button);
		button.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button) {
			countUp();
		}
	}
	
	private void countUp() {
	// 화면이 갱신되지 않는 원래 문제 예제	
//		for(int i=0 ; i<10 ; i++) {
//			System.out.println(Thread.currentThread().getName() + ":countUp:setText(" + i + ")");
//			label.setText("" + i);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO: handle exception
//			}
//		}
	// 수정 후
		new Thread("invokerThread") {
			public void run() {
				System.out.println(Thread.currentThread().getName() + ":invokerThread:BEGIN");
				for(int i=0 ; i<10 ; i++) {
					final String string = "" + i;
					try {
						final Runnable executor = new Runnable() {
							public void run() {
								System.out.println(Thread.currentThread().getName() + ":executor:BEGIN:string = " + string);
								label.setText(string);
								System.out.println(Thread.currentThread().getName() + ":executor:ENDN");
							}
						};
						//executor 를 이벤트 디스패칭쓰레드로 호출하게 한다.
						SwingUtilities.invokeAndWait(executor);
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + ":invokerThread:END");
			}
		}.start();
	}
}
