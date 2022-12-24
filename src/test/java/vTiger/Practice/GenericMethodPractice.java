package vTiger.Practice;



public class GenericMethodPractice 
{

	public static void main(String[] args)
	{
		
		int sum=add(10,20);
		System.out.println(sum);
		
	}
	
	
 /*	public static void add()
	 {
	  int a =10;
	  int b=20;                //not generic methods but only works for 10 and 20
	  int c= a+b;
	  System.out.println(c);
	 } */
	
	public static int add(int a,int b)
    {
	 int c= a+b;              //generic  method
	 return c;
    }
}
	
