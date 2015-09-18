package com.sotong.easy;

import java.util.Scanner;

class MaximumContinuesPartialSum {
    static int N;
    static int A[] = new int[1000001];

    public static void main(String args[]) throws Exception {
	// Scanner sc = new Scanner(new FileInputStream("input.txt"));
	Scanner sc = new Scanner(System.in);

	int T = sc.nextInt();
	for (int test_case = 0; test_case < T; test_case++) {
	    N = sc.nextInt();
	    long total = 0;
	    long max = Integer.MIN_VALUE;
	    for (int i = 0; i < N; i++) {
		A[i] = sc.nextInt();
		total += A[i];
		if (A[i] > max) {
		    max = A[i];
		}
		if (total > max) {
		    max = total;
		}
		if (total < 0) {
		    total = 0;
		}
	    }
	    System.out.println(max);
	}
    }
}