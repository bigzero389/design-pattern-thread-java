package appendixA;

class SubClass {
	public SubClass(){
		System.out.println("A() constructor run");
	}
}

public class InitOrderTest {

	private SubClass a = new SubClass();
	

	{	
		System.out.println("B instance block run");
	}
	
	static{
		System.out.println("B static block run");
	}
	
	private static InitOrderTest b = new InitOrderTest();
	
	private InitOrderTest() {
		System.out.println("B() constructor run");
	}
	
	
	public InitOrderTest(int a) {
		System.out.println("B(int) constructor run");
	}

	
	public static void main(String[] args) {
		new InitOrderTest();
		new InitOrderTest(1);
	}

}
