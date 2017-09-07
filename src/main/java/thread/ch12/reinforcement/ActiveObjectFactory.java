package thread.ch12.reinforcement;

public class ActiveObjectFactory {
	public static ActiveObject createActiveObject() {
		return new ActiveObjectImpl();
	}

}
