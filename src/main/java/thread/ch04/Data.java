package thread.ch04;
import java.io.IOException;
import java.io.FileWriter;
import java.io.Writer;

public class Data {
	private final String fileName;
	private String content;
	private boolean changed;
	
	public Data(String fileName, String content){
		this.fileName = fileName;
		this.content = content;
		this.changed = true;
	}
	
	public synchronized void change(String newContent){
		System.out.println(Thread.currentThread().getName() + " calls doChange, content = " + content);
		content = newContent;
		changed = true;
	}
	
	public synchronized void save(String fromThread) throws IOException {
		if(changed){
			doSave(fromThread);
			changed = false;
		}else{
			System.out.println("Need not save");//exercise 4-2
		}
	}
	
	public void doSave() throws IOException {
		System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
		Writer writer = new FileWriter(fileName);
		writer.write(content);
		writer.close();
	}
	
	public void doSave(String fromThread) throws IOException {
		System.out.println(Thread.currentThread().getName() + " calls : " + fromThread + " doSave, content = " + content);
		Writer writer = new FileWriter(fileName);
		writer.write(content);
		writer.close();
	}

	public synchronized String getContent(){
		return this.content;
	}

}
