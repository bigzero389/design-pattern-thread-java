package thread.ch07.threadFactorySeparate;

public class MyRunnable implements Runnable {
	private final Helper helper = new Helper();
	public final int count;
	public final char c;
	public MyRunnable(int count, char c) {
		this.count = count;
		this.c = c;
	}
	public void run() {
		helper.handle(count, c);
	}
}
