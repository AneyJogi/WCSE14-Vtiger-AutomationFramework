package preprogramming;

public class BinarySearch {
	
	    public static int binarySearch(int[] array, int target) {
	        int first = 0;
	        int last = array.length - 1;
	        while (first <= last) {
	            int middle = (first + last) / 2;
	            if (array[middle] == target) {
	                return middle;
	            } else if (array[middle] < target) {
	            	first = middle + 1;
	            } else {
	                last = middle - 1;
	            }
	        }
	        return -1;
	    }
	    public static void main(String[] args) {
	        int[] array = {1, 3, 5, 7, 9, 11};
	        int target = 7;
	        int index = binarySearch(array, target);
	        if (index != -1) {
	            System.out.println("The target value is at index: " + index);
	        } else {
	            System.out.println("The target value is not present in the array.");
	        }
	    }
	}



