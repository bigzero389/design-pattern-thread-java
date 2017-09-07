package thread.ch02;

import java.util.List;

public class ArrayListThreadWriter extends Thread {
    private final List<Integer> list;
    
    public ArrayListThreadWriter(List<Integer> list){
    	super("ArrayListWriterThread");
    	this.list = list;
    }
    
    public void run(){
    	for(int i=0 ; true ; i++){
    		list.add(i);
    		list.remove(0);
    	}
    }

}
