package thread.ch10.cyclicBarrier;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	private static final int THREADS = 3;
	
	public static void main(String[] args) {
		System.out.println("BEGIN");
		
		ExecutorService service = Executors.newFixedThreadPool(THREADS);
		
		Runnable barrierAction = new Runnable() {
			public void run() {
				System.out.println("Barrier Action !");
			}
		};
		
		CyclicBarrier phaseBarrier = new CyclicBarrier(THREADS, barrierAction);
		
		CountDownLatch doneLatch = new CountDownLatch(THREADS);
		
		try {
			for(int t=0 ; t<THREADS ; t++){
				service.execute(new MyTask(phaseBarrier, doneLatch, t));
			}
			System.out.println("AWAIT");
			doneLatch.await();
		} catch (InterruptedException e) {
			// TODO: handle exception
		} finally {
			service.shutdown();
			System.out.println("END");
		}

	}

}
