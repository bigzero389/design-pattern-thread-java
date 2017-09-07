package thread.ch12;

public class FutureResult<T> extends Result<T> {
	private Result<T> result;
	private boolean ready = false;
	
	public synchronized void setResult(Result<T> result) {
		this.result = result;
		this.ready = true;
		notifyAll();
	}
	
	public synchronized T getResultValue() {
		while(!ready) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		return result.getResultValue();
	}
}
