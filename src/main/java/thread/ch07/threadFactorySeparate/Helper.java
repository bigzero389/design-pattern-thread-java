package thread.ch07.threadFactorySeparate;

public class Helper {

	public void handle(int count, char c) {
		System.out.println(" handle(" + count + ", " + c + ") BEGIN");
		for(int i=0 ; i<count ; i++){
			slowly();
			System.out.println(c);
		}
	}
	
	private void slowly() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

}
