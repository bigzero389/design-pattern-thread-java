package thread.ch12.reinforcement;

import java.util.concurrent.Future;

public interface ActiveObject {
	public abstract Future<String> makeString(int count, char fillChar);
	public abstract void displayString(String string);
	public abstract void shutdown();
}
