package com.mitrais.javabootcamp;
import java.util.Scanner;

public class Stdinout {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);

        int i = in.nextInt();
        double d = in.nextDouble();
        in.nextLine(); // finishes the previous line
        String s = in.nextLine();

        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
