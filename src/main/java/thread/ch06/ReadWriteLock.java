package thread.ch06;

//import java.nio.channels.InterruptedByTimeoutException;

public final class ReadWriteLock {
	private int readingReaders = 0;
	private int waitingWriters = 0;
	private int writingWriters = 0;
	private boolean preferWriter = true;
//	private boolean preferWriter = false;
	
	public synchronized void readLock() throws InterruptedException {
		//현재 쓰고있는 넘이 한개라도 있거나 쓰기를 기다리는 넘이 한개라도 있으면 wating for reader
		//만일 preferWriter=false 이면 쓰기를 기다리는 넘 조건을 무시하고 쓰고있는 넘이 한개라도 있으면 wating
		//즉, 쓰기를 기다리는 넘을 배려하지 않는다. 현재 쓰고있는 넘이 없으면 무조건 reading 한다.
		while(writingWriters>0 || (preferWriter&&waitingWriters>0)) {
			wait();
		}
		readingReaders++;
	}
	
	public synchronized void readUnlock() {
		readingReaders--;
//		preferWriter = false;
		preferWriter = true;
		notifyAll();
	}
	
	public synchronized void writerLock() throws InterruptedException {
		waitingWriters++;
		try {
			//현재 읽거나 쓰는 넘이 한개라도 있으면 wating for writer
			while(readingReaders>0 || writingWriters>0) {
				wait();
			}
		} finally {
			waitingWriters--;
		}
		writingWriters++;
	}
	
	public synchronized void writerUnlock() {
		writingWriters--;
		preferWriter = false;
		notifyAll();
	}
}
