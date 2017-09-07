package thread.ch07;

public class MainExecise {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main BEGIN");
		final HostExecise host = new HostExecise();
		host.request(10, 'A');
		host.request(20, 'B');
		host.request(30, 'C');
		System.out.println("main END");
	}
}
