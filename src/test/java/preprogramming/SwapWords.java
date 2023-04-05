package preprogramming;

import java.util.Scanner;

public class SwapWords {
	
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter a sentence:");
	        String sentence = sc.nextLine();

	        // Split the sentence into words using space as the delimiter
	        String[] words = sentence.split("\\s+");

	        // Swap the first and last words
	        String firstWord = words[0];
	        words[0] = words[words.length - 1];
	        words[words.length - 1] = firstWord;

	        // Concatenate the words back into a sentence
	        String newSentence = String.join(" ", words);
	        System.out.println("New sentence: " + newSentence);
	    }
	}

 
