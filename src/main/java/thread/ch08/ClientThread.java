package thread.ch08;

import java.util.Random;

public class ClientThread extends Thread {
	private final Channel channel;
	private static final Random random = new Random();
	private volatile boolean isStop = false;
	
	public ClientThread(String name, Channel channel) {
		super(name);
		this.channel = channel;
	}
	
	public void run() {
		try {
			for(int i=0 ; !(Shutdown.isSystemStop||isStop) ; i++){
				final Request request = new Request(getName(), i);
				channel.putRequest(request);
				Thread.sleep(random.nextInt(1000));
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println(getName() + " Client Thread is stoped");
//			e.printStackTrace();
		}
	}
	
	public void stopThread() {
		isStop = true;
		this.interrupt();
	}
}
