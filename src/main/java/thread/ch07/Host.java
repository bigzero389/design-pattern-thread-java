package thread.ch07;

public class Host {
	private final Helper helper = new Helper();
	
	public void request(final int count, final char c) {
		System.out.println(" request(" + count + ", " + c + ") BEGIN");
		// Thread 사용
//		new Thread() {
//			public void run() {
//				helper.handle(count, c);
//			}
//		}.start();
		
		// Runnable 사용
		new Thread (
			new Runnable() {
				public void run() {
					helper.handle(count, c);
				}
			}
		).start();
		System.out.println(" request(" + count + ", " + c + ") END");
	}

}
