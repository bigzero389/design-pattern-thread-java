package thread.ch07.swingExercise;
//import java.io.IOException;
//import java.util.concurrent.ThreadFactory;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import thread.ch07.threadFactorySeparate.MyThreadFactory;

@SuppressWarnings("serial")
public class MyFrameThread extends JFrame implements ActionListener {
	
	
	public MyFrameThread() {
		super("MyFrame");
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(new JLabel("Thread-per-Message Sample"));
		JButton button = new JButton("Execute");
		getContentPane().add(button);
		button.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		try {
			new ServiceHost().service();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ServiceHost {
	public static volatile boolean working = false;
	private static final MyThreadFactory threadFactory = new MyThreadFactory();
	
	public void service() throws InterruptedException {
		if(working){
//			System.out.println("service is balked");
			return;
		}
		working = true;
		threadFactory.newThread(new ServiceThread()).start();
	}
		
}

class ServiceThread implements Runnable {
	public void run() {
		doService();
	}
	
	private void doService() {
		try {
			System.out.print("service");
			for(int i=0 ; i<20 ; i++){
				System.out.print(".");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			}
			System.out.println("done.");
		} finally {
			ServiceHost.working = false;
		}

	}
}