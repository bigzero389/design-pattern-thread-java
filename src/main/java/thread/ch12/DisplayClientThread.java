package thread.ch12;

public class DisplayClientThread extends Thread {
	private final ActiveObject activeObject;
	public DisplayClientThread(String name, ActiveObject activeObject) {
		super(name);
		this.activeObject = activeObject;
	}
	
	public void run() {
		try {
			String string;
			for(int i=0 ; true ; i++) {
				string = Thread.currentThread().getName() + " " + i;
				activeObject.displayString(string);
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
}
