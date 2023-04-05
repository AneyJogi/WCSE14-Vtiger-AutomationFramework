package preprogramming;

import java.util.Scanner;

public class StringReverse {
	
	    public static void main(String[] args) {
	        String str = "Saket Saurav";
	        char ch[] = str.toCharArray();  // converted to character array and printed in reverse order
	        for(int i= ch.length-1; i>=0; i--) {
	            System.out.print(ch[i]);
	        }
	        
	        String  reverse = "";
	        System.out.println("Enter the string to be reversed");
	        Scanner in = new Scanner(System.in);
	        String original = in.nextLine();
	        int length = original.length();
	        for(int i=length-1; i>=0; i--) {
	            reverse = reverse + original.charAt(i);   //used inbuilt method charAt() to reverse the string
	        }
	        System.out.println(reverse);
	    
	}

}
