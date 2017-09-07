package thread.ch12;

public class DisplayStringRequest extends MethodRequest<Object> {
	private final String string;
	
	public DisplayStringRequest(ActiveObjectReal servant, String string) {
		super(servant, null);
		this.string = string;
	}
	
	public void execute() {
		servant.displayString(string);
	}

}
