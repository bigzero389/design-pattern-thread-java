package thread.ch07.threadFactorySeparate;

//import java.util.concurrent.ThreadFactory;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main BEGIN");
		Host host = new Host ();
		host.request(new MyRunnable(10, 'A'));
		host.request(new MyRunnable(20, 'B'));
		host.request(new MyRunnable(30, 'C'));
		System.out.println("main END");
	}
}

