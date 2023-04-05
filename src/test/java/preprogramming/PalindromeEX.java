package preprogramming;

import java.util.Scanner;

public class PalindromeEX {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the number:");
		int num= s.nextInt();
		int rev=0;
		int temp= num;
	
		while(num!=0) {
			
			int rem= num%10;
			rev=(rev*10)+rem;
			num= num/10;
		}
		
		System.out.println("The Palindrom  number is:"+rev);

	}

}
