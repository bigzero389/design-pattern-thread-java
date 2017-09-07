package thread.ch01;

public class UserThread extends Thread {
	private final Gate gate;
	private final String myName;
	private final String myAddress;
//	private int threadCnt = 0;

	public UserThread(Gate gate, String myName, String myAddress) {
		this.gate = gate;
		this.myName = myName;
        this.myAddress = myAddress;
	}
	
	public void run() {
		System.out.println(myName + " BEGIN");
		while(true){
//			if((threadCnt % 10000) == 0){
//				System.out.println("Thread Count is : " + threadCnt);
//			}
//			threadCnt++;
			this.gate.pass(myName, myAddress);
		}
	}
}
