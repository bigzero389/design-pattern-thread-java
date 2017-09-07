package thread.ch07;

public class HostExecise {
	
	private final HelperExecise helper = new HelperExecise();
	
	public void request(final int count, final char c) {
		System.out.println(" request(" + count + ", " + c + ") BEGIN");
		new HelperThread(count, c).start();
		System.out.println(" request(" + count + ", " + c + ") END");
	}
	
	
	//Define Thread 
	private class HelperThread extends Thread {
		private final int count;
		private final char c;
		
		public HelperThread(int count, char c){
			this.count = count;
			this.c = c;
		}
		
		public void run() {
			helper.handle(count, c);
		}
	}
	
	//Define Helper
	private class HelperExecise {
		public void handle(int count, char c) {
			System.out.println(" handle(" + count + ", " + c + ") BEGIN");
			for(int i=0 ; i<count ; i++) {
				slowly();
				System.out.println(c);
			}
		}
		
		private void slowly() {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
