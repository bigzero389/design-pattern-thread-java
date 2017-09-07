package thread.ch12;

public class MakerClientThread extends Thread {
	private final ActiveObject activeObject;
	private final char fillChar;
	
	public MakerClientThread(String name, ActiveObject activeObject) {
		super(name);
		this.activeObject = activeObject;
		this.fillChar = name.charAt(0);
	}
	
	public void run() {
		try {
			Result<String> result;
			String value;
			for(int i=0 ; true ; i++){
				result = activeObject.makeString(i, fillChar);
				Thread.sleep(10);
				value = result.getResultValue();
				System.out.println(Thread.currentThread().getName() + ": value = " + value);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

}
