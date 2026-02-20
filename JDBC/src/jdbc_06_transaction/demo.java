package jdbc_06_transaction;

public class demo {
	public static void main(String[] args) {
		
		first();
		fifth();
		second();
		fourth();
		third();
	}
	
	static void first() {
		System.out.println("First");
	}
	
	static void second() {
		System.out.println("second");
	}
	
	static void third() {
		System.out.println("third");
	}
	
	static void fourth() {
		System.out.println("fourth");
	}
	
	static void fifth() {
		System.out.println("fifth");
	}
	
}

