package thread.ch09;

import java.util.concurrent.Callable;

public class HostNew {
	public FutureDataNew request(final int count, final char c) {
		System.out.println(" request(" + count + ", " + c + ") BEGIN");
		
		FutureDataNew future = new FutureDataNew (
			new Callable<RealData>() {
				public RealData call() {
					return new RealData(count, c);
				}
			}
		);
		
		new Thread(future).start();
		
		System.out.println(" request(" + count + ", " + c + ") END ");
		
		return future;
	}

}
