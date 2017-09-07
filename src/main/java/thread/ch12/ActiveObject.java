package thread.ch12;

public interface ActiveObject {
	public abstract Result<String> makeString(int count, char fillChar);
	public abstract void displayString(String string);
}
