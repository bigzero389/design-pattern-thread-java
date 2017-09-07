package thread.ch07;

import java.util.concurrent.Executor;

public class MainExecutor {
	public static void main(String[] args) {
		HostExecutor host = new HostExecutor(
			new Executor() {
				public void execute(Runnable r) {
					new Thread(r).start();
				}
			}
		);
		host.request(10, 'A');
		host.request(20, 'B');
		host.request(30, 'C');
	}

}
