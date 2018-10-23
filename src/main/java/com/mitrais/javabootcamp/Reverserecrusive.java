package com.mitrais.javabootcamp;
import java.util.Scanner;

public class Reverserecrusive {

	String reverse = "";
	StringBuilder sb = new StringBuilder();
	
	 public String reverseString(String str){
		 
		 if ((str.length() <= 0) )
	            return str;
		 
		 sb.append(str.charAt(str.length()-1));
		 reverseString(str.substring(0,str.length()-1));
		 
	 return sb.toString();

	 }


	 public static void main(String a[]){
		 Scanner sc = new Scanner(System.in);
		 String input = sc.nextLine();
		 
		 Reverserecrusive rev = new Reverserecrusive();
		 System.out.println("Result: "+rev.reverseString(input));

	 }
}
                                  

















