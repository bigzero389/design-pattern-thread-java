package thread.ch02;

public final class ImmutableCheck {
	public static void main(String[] args) {
		MutablePerson mutable = new MutablePerson("start", "start");
		new CrackerThread(mutable).start();
		new CrackerThread(mutable).start();
		new CrackerThread(mutable).start();

		for(int i=0 ; true ; i++){
			mutable.setPerson("" + i, "" + i);
		}
	}
}

class CrackerThread extends Thread {
	private final MutablePerson mutable;
	public CrackerThread(MutablePerson mutable){
		this.mutable = mutable;
	}
	
	public void run(){
		while(true){
			ImmutablePerson immutable = new ImmutablePerson(mutable);
			if(!immutable.getName().equals(immutable.getAddress())){
				System.out.println(currentThread().getName() + " ***** BROKEN ***** " + immutable);
			}
		}
	}
}

//Mutable Person Class
final class MutablePerson {
	private String name;
	private String address;
	
	public MutablePerson(String name, String address){
		this.name = name;
		this.address = address;
	}
	
	public MutablePerson(ImmutablePerson person){
		this.name = person.getName();
		this.address = person.getAddress();
	}
	
	public synchronized void setPerson(String newName, String newAddress) {
		this.name = newName;
		this.address = newAddress;
	}
	
	public synchronized ImmutablePerson getImmutablePerson() {
		return new ImmutablePerson(this);
	}

	String getName() {
		return this.name;
	}
	
	String getAddress() {
		return this.address;
	}

	public String toString() {
		return "[ MutablePerson: " + name + ", " + address + " ]";
	}
}

//Immutable Person Class
final class ImmutablePerson {
	private final String name;
	private final String address;
	
	public ImmutablePerson (String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public ImmutablePerson (MutablePerson person) { //if it's in multi-thread, then it can change threads between set name and set address 
		synchronized(person){  // If you want immutable class , you have to use synchronized at person instance
			this.name = person.getName();
		    this.address = person.getAddress();
		}
	}
	
	public MutablePerson getMutablePerson() {
		return new MutablePerson(this);
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String toString() {
		return "[ ImmutablePerson: " + name + ", " + address + " ]";
	}
	
}