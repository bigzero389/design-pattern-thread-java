package thread.ch07;

import java.util.concurrent.ThreadFactory;

public class HostThreadFactory {
	private final Helper helper = new Helper();
	private final ThreadFactory threadFactory;
	
	public HostThreadFactory(ThreadFactory threadFactory) {
		this.threadFactory = threadFactory;
	}
	
	public void request(final int count , final char c){
		System.out.println(" request(" + count + ", " + c + ") BEGIN");
		
		threadFactory.newThread(
			new Runnable() {
				public void run() {
					helper.handle(count, c);
				}
			}
		).start();
		
		System.out.println(" request(" + count + ", " + c + ") END");
	}


}
