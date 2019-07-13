package org.daniel.binaryconversionpractice.main;

import java.util.Scanner;

public class BinaryConversionPractice {
	
	// Cheat Sheet:
	// _   _  _  _  _ _ _ _
	// 128 64 32 16 8 4 2 1

	public static void main(String[] args) {
		// declare and init scanner for user input
		Scanner scanner = new Scanner(System.in);
		// streak of correct answers
		int streak = 0;
		// main loop
		while (true) {
			// generate random double within [0, 256) and round down to an int
			int randomNumber = (int) (256d * Math.random());
			// print newly generated number
			System.out.println(randomNumber);
			// get input from user
			String in = scanner.next();
			// add 1 to the streak if user answered correctly, set it to 0 if otherwise
			streak = (in.equals(calculateBinary(randomNumber))) ? streak + 1 : 0;
			// print the correct bits if the user answered incorrectly, print correct otherwise
			System.out.println((streak == 0) ? calculateBinary(randomNumber) : "Correct");
			// print the streak
			System.out.println("Streak: " + streak);
		}
	}
	
	// method to calculate binary (returns minimum 8 bits, but because [0, 255] is always passed to it, it will always return 8 bits)
	private static String calculateBinary(int num) {
		// generate binary of num
		StringBuilder binary = new StringBuilder(Integer.toBinaryString(num));
		// add on 0s to make it at least 8 bits long
		while (binary.length() < 8) {
			// binary is of type StringBuilder so .insert() can be used
			binary.insert(0, '0');
		}
		// return the bits as a String
		return binary.toString();
	}

}
