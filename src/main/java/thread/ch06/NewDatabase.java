package thread.ch06;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class NewDatabase<K,V> {
	private final Map<K,V> map = new HashMap<K,V>();
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock readLock = lock.readLock();
	private final Lock writeLock = lock.writeLock();
	
	public void clear() {
		writeLock.lock();
		try {
			verySlowly();
			map.clear();
		} finally {
			writeLock.unlock();
		}
	}
	
	public void assign(K key, V value){
		writeLock.lock();
		try {
			verySlowly();
			map.put(key, value);
		} finally {
			writeLock.unlock();
		}
	}
	
	public V retrieve(K key) {
		readLock.lock();
		try {
			slowly();
			return map.get(key);
		} finally {
			readLock.unlock();
		}
	}
	
	private void slowly() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
	private void verySlowly() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

}
