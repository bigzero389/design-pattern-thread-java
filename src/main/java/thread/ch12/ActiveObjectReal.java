package thread.ch12;

public class ActiveObjectReal implements ActiveObject {

	public Result<String> makeString(int count, char fileChar) {
		char[] buffer = new char[count];
		for(int i=0 ; i<count ; i++){
			buffer[i] = fileChar;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		return new RealResult<String>(new String(buffer));
	}
	
	public void displayString(String string) {
		try {
			System.out.println("displayString: " + string);
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
}
