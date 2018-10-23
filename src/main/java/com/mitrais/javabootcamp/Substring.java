package com.mitrais.javabootcamp;
import java.util.Scanner;

public class Substring {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String S = in.next();
	        int start = in.nextInt();
	        int end = in.nextInt();
	        
	        String result = S.substring(start, end);
	        System.out.println(result);
	    }
}
