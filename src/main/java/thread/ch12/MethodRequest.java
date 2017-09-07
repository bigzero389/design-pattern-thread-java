package thread.ch12;

abstract class MethodRequest<T> {
	protected final ActiveObjectReal servant;
	protected final FutureResult<T> futureResult;
	
	public MethodRequest(ActiveObjectReal servant, FutureResult<T> futureResult) {
		this.servant = servant;
		this.futureResult = futureResult;
	}
	
	public abstract void execute();
}
