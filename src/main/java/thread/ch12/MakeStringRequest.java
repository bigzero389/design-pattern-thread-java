package thread.ch12;

public class MakeStringRequest extends MethodRequest<String> {
	private final int count;
	private final char fillChar;
	
	public MakeStringRequest(ActiveObjectReal servant, FutureResult<String> futureResult, int count, char fillChar) {
		super(servant, futureResult);
		this.count = count;
		this.fillChar = fillChar;
	}
	
	public void execute() {
		Result<String> result = servant.makeString(count, fillChar);
		futureResult.setResult(result);
	}
}
