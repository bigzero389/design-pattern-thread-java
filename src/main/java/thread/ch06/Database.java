package thread.ch06;
import java.util.Map;
import java.util.HashMap;

public class Database<K,V> {
	
	private final Map<K,V> map = new HashMap<K,V>();
	
	public synchronized void clear() {
		verySlowly();
		map.clear();
	}
	
	public synchronized void assign(K key, V value){
		verySlowly();
		map.put(key, value);
	}
	
	public synchronized V retrieve(K key) {
		slowly();
		return map.get(key);
	}
	
	private void slowly() {
		try {
			Thread.sleep(50);
//			wait(50);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
	private void verySlowly() {
		try {
			Thread.sleep(500);
//			wait(500);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

}
