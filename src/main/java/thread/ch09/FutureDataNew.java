package thread.ch09;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureDataNew extends FutureTask<RealData> implements Data {
	public FutureDataNew(Callable<RealData> callable) {
		super(callable);
	}
	
	public String getContent() {
		String string = null;
		try {
			string = get().getContent();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		return string;
	}

}
