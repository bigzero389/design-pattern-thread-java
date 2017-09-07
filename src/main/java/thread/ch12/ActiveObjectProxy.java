package thread.ch12;

public class ActiveObjectProxy implements ActiveObject {
	private final SchedulerThread scheduler;
	private final ActiveObjectReal servant;
	
	public ActiveObjectProxy(SchedulerThread scheduler, ActiveObjectReal servant) {
		this.scheduler = scheduler;
		this.servant = servant;
	}
	
	public Result<String> makeString(int count, char fillChar) {
		FutureResult<String> future = new FutureResult<String>();
		scheduler.invoke(new MakeStringRequest(servant, future, count, fillChar));
		return future;
	}
	
	public void displayString(String str) {
		scheduler.invoke(new DisplayStringRequest(servant, str));
	}

}
