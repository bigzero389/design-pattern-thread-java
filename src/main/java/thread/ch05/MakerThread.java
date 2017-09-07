package thread.ch05;

import java.util.Random;

public class MakerThread extends Thread {
	private  final Random random;
	private final Table table;
//	private final NewTable table;
	private static int id = 0;
	
	public MakerThread(String name, Table table, long seed) {
//	public MakerThread(String name, NewTable table, long seed) {
		super(name);
		this.table = table;
		this.random = new Random(seed);
	}
	
	public void run() {
		try {
			while(true){
				Thread.sleep(random.nextInt(1000));
				String cake = "[ Cake No." + nextId() + " by " + getName() + " ]";
				table.put(cake);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
	public static synchronized int nextId() {
		return id++;
	}

}
