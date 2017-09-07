package thread.ch12;

public class ActiveObjectFactory {
	public static ActiveObject createActiveObject() {
		ActiveObjectReal servant = new ActiveObjectReal();
		ActivationQueue queue = new ActivationQueue();
		SchedulerThread scheduler = new SchedulerThread(queue);
		ActiveObjectProxy proxy = new ActiveObjectProxy(scheduler, servant);
		scheduler.start();
		return proxy;
	}
}
