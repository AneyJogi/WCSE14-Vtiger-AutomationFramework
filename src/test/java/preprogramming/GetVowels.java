package preprogramming;

import java.util.Scanner;

public class GetVowels {
	
	    public static void main(String[] args) {
	   
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scan.nextLine();

        String result = "";

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                result = result + c + " ";
              
            }
        }
 
        System.out.println("Vowels in your name: " + result);
    }
}


