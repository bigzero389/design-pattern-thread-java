package thread.ch09.problem;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Retriever {
	public static Content retrieve(final String urlStr) throws Exception {
		//Multi-Thread
		MyFutureData future = new MyFutureData (
			new Callable<Content>() {
				public Content call() {
					return new SyncContentImpl(urlStr);
				}
			}
		);
			
		new Thread(future).start();

		return future.get();
		
		// Non Multi-Thread
//		return new SyncContentImpl(urlStr);

	}
}

class MyFutureData extends FutureTask<Content> {
	public MyFutureData(Callable<Content> collable) {
		super(collable);
	}
}
