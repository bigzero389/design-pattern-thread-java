package thread.ch07.threadFactorySeparate;

//import java.util.concurrent.ThreadFactory;

public class Host {
//	private final Helper helper = new Helper();
	private final MyThreadFactory threadFactory = new MyThreadFactory();
	
	public void request(MyRunnable myRunnable){
		System.out.println(" request(" + myRunnable.count + ", " + myRunnable.c + ") BEGIN");
		threadFactory.newThread(myRunnable).start();
		System.out.println(" request(" + myRunnable.count + ", " + myRunnable.c + ") END");
	}
}
