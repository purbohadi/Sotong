package com.sotong.easy;
import java.util.Scanner;

public class SerialDigit {
	static int sNum = 0;
	static int retNum[] = new int[8];

	static boolean isprime(int n) {
		int i;
		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;
		for (i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}

	static void sprime(int n, int ndigit) {
		if (ndigit == 0) {
			System.out.printf("%d\n", n);
			return;
		}

		n *= 10;
		if (isprime(n + 1)) {
			sprime(n + 1, ndigit - 1);
		}
		if (isprime(n + 3)) {
			sprime(n + 3, ndigit - 1);
		}
		if (isprime(n + 7)) {
			sprime(n + 7, ndigit - 1);
		}
		if (isprime(n + 9)) {
			sprime(n + 9, ndigit - 1);
		}
	}

	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			sNum = sc.nextInt();
			sprime(2, sNum - 1);
			sprime(3, sNum - 1);
			sprime(5, sNum - 1);
			sprime(7, sNum - 1);
			System.out.println();
		}
		System.out.println();
	}
}
