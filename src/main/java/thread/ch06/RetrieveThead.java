package thread.ch06;
import java.util.concurrent.atomic.AtomicInteger; // Thread Safety 한 전역변수 형태의 정수

public class RetrieveThead extends Thread {
	private final Database<String,String> database;
//	private final NewDatabase<String,String> database;
	private final String key;
	private static final AtomicInteger atomicCounter =  new AtomicInteger(0);
	
	public RetrieveThead(Database<String,String> database, String key) {
//	public RetrieveThead(NewDatabase<String,String> database, String key) {
		this.database = database;
		this.key = key;
	}
	
	public void run() {
//		String value = "";
		while(true) {
			int counter = atomicCounter.incrementAndGet();
			String value = database.retrieve(key);
			System.out.println(counter + ":" + key + " => " + value);
//			System.out.println(atomicCounter.incrementAndGet() + ":" + key + "=>" + database.retrieve(key));
		}
	}

}
