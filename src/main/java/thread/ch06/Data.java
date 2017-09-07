package thread.ch06;

public class Data {
	private final ReadWriteLock lock = new ReadWriteLock();
	private final char[] buffer;
	private final int bufferSize;
	
	public Data(int size) {
		// 생성자는 Thread Safety 하다.
		this.buffer = new char[size];
		this.bufferSize = size;
		for(int i=0 ; i<bufferSize ; i++) {
			buffer[i] = '*';
		}
	}
	
	public char[] read() throws InterruptedException {
		lock.readLock();
		try {
			return doRead();
		} finally {
			lock.readUnlock();
		}
	}
	
	public void writer(char c) throws InterruptedException {
		lock.writerLock();
		try {
			doWriter(c);
		} finally { 
			lock.writerUnlock();
		}
	}
	
	private char[] doRead() {
		char[] newbuf = new char[bufferSize];
		for(int i=0 ; i<bufferSize ; i++) {
			newbuf[i] = buffer[i];
		}
		slowly();
		return newbuf;
	}
	
	private void doWriter(char c) {
		for(int i=0 ; i<bufferSize ; i++) {
			buffer[i] = c;
			slowly();
		}
	}
	
	private void slowly() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

}
