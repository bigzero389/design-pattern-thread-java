package thread.ch03;


public class GuardedSuspensionMain {
	public static void main(String[] args) {
//		RequestQueue requestQueue = new RequestQueue();
		RequestBlockingQueue requestQueue = new RequestBlockingQueue();
		new ClientThread(requestQueue, "Alice", 2131592L).start();
		new ServerThread(requestQueue, "Bobby", 6535897L).start();
	}
}
