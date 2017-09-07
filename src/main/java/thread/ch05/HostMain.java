package thread.ch05;

class Host {
	public static void execute(int count) throws InterruptedException {
		for(int i=0 ; i<count ; i++){
			if(Thread.interrupted()){
				throw new InterruptedException();
			}
			doHeavyJob();
		}
	}
	
	private static void doHeavyJob() {
		System.out.println("doHeavyJob BEGIN");
		long start = System.currentTimeMillis();
		while(start+1000 > System.currentTimeMillis()){
			//busy loop
		}
		System.out.println("doHeavyJob END");
	}

}

class HostThread extends Thread {
	private int count;
	
	public HostThread(int count){
		this.count = count;
	}
	
	public void run() {
		for(int i=0 ; i<count ; i++){
			if(Thread.interrupted()){
				try {
					throw new InterruptedException();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				}
			}else{
				doHeavyJob();
			}
		}
	}
	
	private void doHeavyJob() {
		System.out.println("doHeavyJob BEGIN");
		long start = System.currentTimeMillis();
		while(start+1000 > System.currentTimeMillis()){
			//busy loop
		}
		System.out.println("doHeavyJob END");
	}
	
}

public class HostMain {
	public static void main(String[] args) {
		Thread hostExecuter = new Thread() {
			public void run() {
				System.out.println("Host execute BEGIN");
				try {
					Host.execute(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Host execute END");
			}
		};
		
		hostExecuter.start();
		
//		HostThread hostThread = new HostThread(1000);
//		hostThread.start();
//		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Host executer Interrupted");
		hostExecuter.interrupt();
//		hostThread.interrupt();
		
	}
	
}