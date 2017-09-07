package thread.ch09;

public class Host {
	public Data request(final int count, final char c) {
		System.out.println(" request(" + count + ", " + c + ") BEGIN");
		
		final FutureData future = new FutureData();
		
		new Thread() {
			public void run() {
				try {
					RealData realData = new RealData(count, c);
					future.setRealData(realData);
				} catch (Exception e) {
					// TODO: handle exception
					future.setException(e);
				}
			}
		}.start();
		
		System.out.println(" request(" + count + ", " + c + ") END ");
		
		return future;
	}

}
