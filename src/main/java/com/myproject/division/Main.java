package main.java.com.myproject.division;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter devidend and divider");
		int dividend = input.nextInt();
        int divider = input.nextInt();
		System.out.println(new Division().divideTwoInt(dividend,divider));
	}
}
