package com.mitrais.javabootcamp;
import java.util.Scanner;

public class Integertobinary {
	
	public static String convToBinary(int num)
	{
	    String res = "";
	    String tmp = "";
	    while (num > 0)
	    {

	    	if ((num % 2) == 0) {
				tmp = "0";
			}else {
				tmp="1";
			}
	    	res=tmp+res;

	        num = num / 2;
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner( System.in );

        System.out.println("Enter Integer: ");
        Integer input =sc.nextInt();
        
		System.out.println("Binary: "+convToBinary(input));
	}
}
