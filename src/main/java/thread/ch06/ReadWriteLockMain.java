package thread.ch06;

public class ReadWriteLockMain {

	public static void main(String[] args) {
		Data data = new Data(10);
		new ReaderThread(data).start();
		new ReaderThread(data).start();
		new ReaderThread(data).start();
		new ReaderThread(data).start();
		new ReaderThread(data).start();
		new ReaderThread(data).start();
		new WriterThread(data, "ABCDEFGHIJKLMNOPQRSTUVWXYZ").start(); 
		new WriterThread(data, "abcdefghijklmnopqrstuvwxyz").start();
		// TODO Auto-generated method stub

	}

}
