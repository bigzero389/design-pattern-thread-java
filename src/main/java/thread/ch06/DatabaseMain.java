package thread.ch06;

public class DatabaseMain {
	
	public static void main(String[] args) {
//		NewDatabase<String,String> database  = new NewDatabase<String,String>();
		Database<String,String> database  = new Database<String,String>();
		
		new AssignThread(database, "Alice", "Alaska").start();
		new AssignThread(database, "Alice", "Australia").start();
		new AssignThread(database, "Bobby", "Brazil").start();
		new AssignThread(database, "Bobby", "Bulgaria").start();
		
		//Assign 이 끝나기전에 Retrieve 가 처리되는 현상 발생함
		//Database instance의 lock 이 제어되지 않은듯 보임, 예제가 정상작동하지 않음
		//원인파악 필요
		for(int i=0 ; i<100 ; i++) { 
			new RetrieveThead(database, "Alice").start();
			new RetrieveThead(database, "Bobby").start();
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	
		System.exit(0);
	}
	

}
