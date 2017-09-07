package thread.ch11;
//import java.io.File;

public class Log {
	private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<TSLog>();
	
	public static void println(String s) {
		getTSLog().println(s);
	}
	
	public static void close() {
		getTSLog().close();
	}
	
	private static TSLog getTSLog() {
		TSLog tsLog = tsLogCollection.get();
		if(tsLog == null) {
			String logFileName = Thread.currentThread().getId() + "_" + Thread.currentThread().getName() + "-log.txt"; 
			tsLog = new TSLog(logFileName);
			tsLogCollection.set(tsLog);
			startWatcher(tsLog);
		}
		return tsLog;
	}
	
	private static void startWatcher(final TSLog tsLog) {
		final Thread target = Thread.currentThread();
		final Thread watcher = new Thread() {
			public void run() {
				System.out.println("startWatcher for " + target.getId() + "_" + target.getName() + " BEGIN");
				try {
					target.join();
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				tsLog.close();
				System.out.println("startWatcher for " + target.getId() + "_" + target.getName() + " END");
			}
		};
		watcher.start();
	}

}
