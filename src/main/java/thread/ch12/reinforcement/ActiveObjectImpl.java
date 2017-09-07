package thread.ch12.reinforcement;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ActiveObjectImpl implements ActiveObject {
	private final ExecutorService service = Executors.newSingleThreadExecutor();
	
	public void shutdown() {
		service.shutdown();
	}
	
	public Future<String> makeString(final int count, final char fillChar) {
		
		class MakeStringRequest implements Callable<String> {
			public String call() {
				char[] buffer = new char[count];
				for(int i=0 ; i<count ; i++){
					buffer[i] = fillChar;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
				}
				return new String(buffer);
			}
		}
		
		return service.submit(new MakeStringRequest());
	}
	
	public void displayString(final String str) {
		
		class DisplayStringRequest implements Runnable {
			public void run() {
				try {
					System.out.println("displayString " + str);
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
		}

		service.execute(new DisplayStringRequest());
	}
}

