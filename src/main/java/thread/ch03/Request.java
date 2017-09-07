package thread.ch03;
import java.text.SimpleDateFormat;
import java.util.Date;                                                                                                                                                                                                                                                                                                                                                                                                                                             
class Request {
    private final String name;
    private final long makeTime;
    

	public Request(String name){
		this.name = name;
		this.makeTime = System.currentTimeMillis(); 
	}
	
	public String getName(){
		return this.name;
	}
	
	public String toString(){
		return "[ Request " + this.name + ": " + viewTime(this.makeTime) + " ]";
	}
	
	String viewTime(long millTime){
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm;ss");
		return dayTime.format(new Date(millTime));
	}

}