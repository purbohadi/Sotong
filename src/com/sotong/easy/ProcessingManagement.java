package com.sotong.easy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProcessingManagement {

    static int N;
    static int[] Li;
    static int[] Wi;
    static int Answer;
    public static int[] lds;

    public static void main(String[] args) throws FileNotFoundException {

	// Scanner sc = new Scanner(System.in);
	Scanner sc = new Scanner(
		new FileInputStream("src/input/processingManagement.txt"));

	int T = sc.nextInt();
	for (int test_case = 0; test_case < T; test_case++) {
	    N = sc.nextInt();
	    Li = new int[N];
	    Wi = new int[N];
	    for (int i = 0; i < N; i++) {
		Li[i] = sc.nextInt();
		Wi[i] = sc.nextInt();
	    }
	    /**********************************
	     * Implement your algorithm here. *
	     ***********************************/
	    Answer = 0;

	    insertIntoSorted(Li);

	    lds = new int[N];

	    for (int i = 0; i < N; i++) {// initialize LDS array
		lds[i] = 1;
	    }

	    for (int i = N - 1; i >= 0; --i) {
		for (int j = N - 1; j > i; --j) {
		    if (Wi[i] > Wi[j] && lds[i] < lds[j] + 1) {
			lds[i] = lds[j] + 1;
		    }
		}
	    }

	    for (int i = 0; i < lds.length; ++i) {
		if (Answer < lds[i]) {
		    Answer = lds[i];
		}
	    }

	    System.out.println(Answer);
	}

    }

    public static void insertIntoSorted(int[] ar) {

	for (int i = 0; i < ar.length; i++) {
	    int temp = ar[i];
	    int W = Wi[i];
	    int j;
	    for (j = i - 1; j >= 0 && temp < ar[j]; j--) {
		ar[j + 1] = ar[j];
		Wi[j + 1] = Wi[j];
	    }
	    ar[j + 1] = temp;
	    Wi[j + 1] = W;
	}

    }

}
