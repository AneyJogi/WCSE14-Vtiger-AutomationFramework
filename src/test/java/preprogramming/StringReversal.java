package preprogramming;

public class StringReversal {

		  public static void main(String[] args) {
		    String original = "international day";
		    char[] originalArray = original.toCharArray();
		    int start = 0;
		    int end = originalArray.length - 1;
		    while (start < end) {
		        char temp = originalArray[start];
		        originalArray[start] = originalArray[end];
		        originalArray[end] = temp;   
		        start++;
		        end--;
		    }
		    String reversedString = new String(originalArray);
		    System.out.println(reversedString);
		  }
		}



