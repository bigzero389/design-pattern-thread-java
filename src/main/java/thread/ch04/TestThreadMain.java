package thread.ch04;

public class TestThreadMain {

	public static void main(String[] args) {
		Thread thread = new TestThread();
		while(true){
			if(thread.getState() == Thread.State.NEW){ // To avoid IllegalThreadStateException
				thread.start();
			}
		}

	}

}
