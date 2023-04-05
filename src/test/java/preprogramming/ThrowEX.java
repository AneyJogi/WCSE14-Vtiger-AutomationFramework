package preprogramming;
public class ThrowEX {

	public static void main(String[] args) {
		ThrowEX t= new ThrowEX();
		t.checkAge(16);
		
	}

public 	void checkAge(int age) {
	    if (age < 18) {
	        throw new ArithmeticException("Age must be greater than 18");
	    } else {
	        System.out.println("Eligible for voting");
	    }
	}
}
