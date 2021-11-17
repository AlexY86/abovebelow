package com.demo1.abovebelow;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class aboveBelow {

	static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int size = arraySize();
		int[] array = new int[size];
		randomOrSpecific(size, array);

		printNumbers(array, getNumber());
	}

	private static int arraySize() {
		System.out.print("How long is the array? ");
		while (true) {
			String s = input.nextLine();
			try {
				int size = Integer.parseInt(s);
				return size;
			} catch (NumberFormatException exception) {
				System.out.println("Enter the length as an integer:");
				System.out.print("How long is the array? ");
			}
		}
	}

	private static void randomOrSpecific(int size, int[] array) {
		System.out.println("Would you prefer random integers or to input specific integers?");
		int answer = 0;
		do {
			System.out.println("Press '1' for random integers, or '2' for specifc integers");
			try {
				answer = input.nextInt();
			} catch (InputMismatchException exception) {
				input.nextLine();
			}
		} while (answer != 1 && answer != 2);

		if (answer == 1) {
			System.out.println("Generating " + size + " random integers");
			randomInts(array);
		} else {
			specificInts(array);
		}
	}

	private static int[] randomInts(int[] array) {
		for (int i = 0; i < array.length; i++) {
			Random random = new Random();
			int randomInt = random.nextInt(99) + 1;
			array[i] = randomInt;
		}
		input.nextLine();
		return array;
	}

	private static int[] specificInts(int[] array) {
		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				System.out.print("Enter an integer you would like in the array: ");
			} else if (i < array.length - 1) {
				System.out.print("Enter the next integer for the array: ");
			} else {
				System.out.print("Enter the last integer for the array: ");
			}
			try {
				temp = input.nextInt();
				array[i] = temp;
			} catch (InputMismatchException exception) {
				i -= 1;
				System.out.println("Please only enter integers");
				input.nextLine();
				continue;
			}
		}
		input.nextLine();
		return array;
	}

	private static int getNumber() {
		System.out.print("Enter an integer to see how many values ");
		System.out.println("within the array are above it and how many are below it.");

		while (true) {
			String s = input.nextLine();
			try {
				int test = Integer.parseInt(s);
				return test;
			} catch (NumberFormatException exception) {
			}
			System.out.println("Please enter an integer...");
		}
	}

	private static void printNumbers(int[] array, int test) {
		int aboveCount = 0;
		int belowCount = 0;
		System.out.print("Array = [ ");
		for (int i = 0; i < array.length; i++) {
			if (array[i] > test) {
				aboveCount++;
			} else if (array[i] < test) {
				belowCount++;
			}
			System.out.print(array[i] + " ");
		}
		System.out.printf("%s%n%s %d%n", "]", "Test Number:", test);
		System.out.printf("%s %d, %s %d%n", "Above:", aboveCount, "Below:", belowCount);
	}
}