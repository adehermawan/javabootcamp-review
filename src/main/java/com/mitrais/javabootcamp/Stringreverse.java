package com.mitrais.javabootcamp;
import java.util.Scanner;

public class Stringreverse {
public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        String result = new StringBuffer(s).reverse().toString();
        if (result.equals(s)) {
			System.out.println("palindrom");
		}else {
			System.out.println("Bukan");
		}
    }
}
