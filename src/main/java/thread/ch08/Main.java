package thread.ch08;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Channel channel = new Channel(5);
		channel.startWorkers();
		ClientThread alice = new ClientThread("Alice", channel);
		ClientThread bobby = new ClientThread("Bobby", channel);
		ClientThread chris = new ClientThread("Chris", channel);
		
		alice.start();
		bobby.start();
		chris.start();

		try {
			Thread.sleep(5000);
			alice.stopThread();
//			bobby.stopThread();
//			chris.stopThread();
			
//			Shutdown.stopSystem();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

}


class Shutdown{
	public static volatile boolean isSystemStop = false;
	
	public static synchronized void stopSystem() {
		isSystemStop = true;
	}
}