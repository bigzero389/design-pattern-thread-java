package thread.ch10;

public class CountupThread extends Thread {
	private long counter = 0;
	private volatile boolean shutdownRequested = false;
	
	public void shutdownRequest() {
		shutdownRequested = true;
		System.out.println("호출한 넘은 누구 ? " + Thread.currentThread().getName());
		interrupted();
	}
	
	public boolean isShutdownRequested() {
		return shutdownRequested;
	}
	
	public final void run() {
		try {
			while(!isShutdownRequested()){
				doWork();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		} finally {
			doShutdown();
		}
	}
	
	private void doWork() throws InterruptedException {
		counter++;
		System.out.println("doWork: counter = " + counter);
		Thread.sleep(500);
	}
	
	private void doShutdown() {
		System.out.println("doShutdown: counter = " + counter);
	}

}
