package thread.ch05;

public class ProducerConsumerMain {

	public static void main(String[] args) {
		Table table = new Table(3);
//		NewTable table = new NewTable(3);
		Thread[] threads = new Thread[7];
		threads[0] = new MakerThread("MakerThread-1", table, 31415);
		threads[1] = new MakerThread("MakerThread-2", table, 92653);
		threads[2] = new MakerThread("MakerThread-3", table, 58979);
		threads[3] = new EaterThread("EaterThread-1", table, 32384);
		threads[4] = new EaterThread("EaterThread-2", table, 62643);
		threads[5] = new EaterThread("EaterThread-3", table, 38327);
		threads[6] = new ClearThread("ClearThread", table);
		
		for(int i=0,j=threads.length ; i<j ; i++){
			threads[i].start();
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0,j=threads.length ; i<j ; i++){
			threads[i].interrupt();
		}
		System.out.println("Threads Interrupted!!!");
	}
}
