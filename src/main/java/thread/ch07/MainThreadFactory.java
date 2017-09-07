package thread.ch07;

import java.util.concurrent.Executors;

public class MainThreadFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main BEGIN");
		HostThreadFactory host = new HostThreadFactory (
			//Executors 클래스를 사용하는 방법
			Executors.defaultThreadFactory()	
			//ThreadFactory를 생성하여 사용하는 방법
//			new ThreadFactory() {
//				public Thread newThread(Runnable r) {
//					return new Thread(r);
//				}
//			}
		);
		host.request(10, 'A');
		host.request(20, 'B');
		host.request(30, 'C');
		System.out.println("main END");
	}
}
