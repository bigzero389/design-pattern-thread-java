package thread.ch02;

public class UserInfoModifyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserInfo userInfo = new UserInfo("Alice", "Alaska");
		System.out.println("Before userInfo = " + userInfo);
		StringBuffer info = userInfo.getInfo();
		info.replace(12, 17, "Bobby");   // You can change the value of userInfo what I guess immutable
		System.out.println("After userInfo = " + userInfo);
	}
}

final class UserInfo {
	private final StringBuffer info; // info variable might be immutable but...
	public UserInfo(String name, String address){
		this.info = new StringBuffer("<info name=\"" + name + "\" address=\"" + address + "\" />");
	}
	
	public StringBuffer getInfo(){
		return this.info;
	}
	
	public String toString(){
		return "[ UserInfo: " + info + " ]";
	}
	
}
