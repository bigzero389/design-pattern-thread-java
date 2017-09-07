package thread.ch12.reinforcement;

public class Main {
	public static void main(String[] args) {
		ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
		try {
			new MakerClientThread("Alice", activeObject).start();
			new MakerClientThread("Bobby", activeObject).start();
			new DisplayClientThread("Chris", activeObject).start();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		} finally {
			System.out.println("*** shutdown ***");
			activeObject.shutdown();
		}
	}

}
