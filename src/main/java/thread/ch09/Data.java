package thread.ch09;

import java.util.concurrent.ExecutionException;

public interface Data {
	public abstract String getContent() throws ExecutionException;

}
