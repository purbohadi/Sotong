package com.sotong.easy;
/*

In Practice, You should use the statndard input/output
in order to receive a score properly.
Do not use file input and output. Please be very careful. 

 */

import java.util.Scanner;
import java.io.FileInputStream;

class DominoTiling {
	static int N, M;
	static int Answer;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		// sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();

			/**********************************
			 * Implement your algorithm here. *
			 ***********************************/
			Answer = 0;

			if (N == 1)
				Answer = 1;
			else if (N == 2)
				Answer = 3;
			else {
				int len1 = 1, len2 = 3;
				for (int i = 3; i <= N; i++) {

					Answer = (len2 + 2 * len1) % M;
					len1 = len2;
					len2 = Answer;
				}
			}
			// Print the answer to standard output(screen).
			System.out.println((Answer % M));
		}
	}
}
