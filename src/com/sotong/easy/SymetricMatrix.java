package com.sotong.easy;

/*


 In Practice, You should use the statndard input/output
 in order to receive a score properly.
 Do not use file input and output. Please be very careful. 

 */

import java.util.Scanner;
import java.io.FileInputStream;

/*
 As the name of the class should be Algorithm , using Algorithm.java as the filename is recommended.
 In any case, you can execute your program by running 'java Algorithm' command.
 */
class SymetricMatrix {
    static int N;
    static char data[] = new char[130];

    public static void main(String args[]) throws Exception {
	/*
	 * The method below means that the program will read from input.txt,
	 * instead of standard(keyboard) input. To test your program, you may
	 * save input data in input.txt file, and call below method to read from
	 * the file when using nextInt() method. You may remove the comment
	 * symbols(//) in the below statement and use it. But before submission,
	 * you must remove the freopen function or rewrite comment symbols(//).
	 */

	/*
	 * Make new scanner from standard input System.in, and read data.
	 */
	Scanner sc = new Scanner(new FileInputStream("src/input/symetricMatrix.txt"));
	//Scanner sc = new Scanner(System.in);

	int T = sc.nextInt();
	for (int test_case = 0; test_case < T; test_case++) {
	    N = sc.nextInt();
	    for (int i = 0; i < N; i++) {
		data[i] = sc.next().toCharArray()[0];
	    }

	    // ///////////////////////////////////////////////////////////////////////////////////////////

	    char arr[][] = new char[N][N];
	    buildMatrix(arr, data, 0, 0, N);
	    // ///////////////////////////////////////////////////////////////////////////////////////////

	    for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
		    System.out.print(arr[i][j] + " ");
		}
		System.out.println();
	    }
	    System.out.println();

	}
    }

    public static void buildMatrix(char[][] arr, char[] s, int row, int col,
	    int length) {
	if (length <= 2) {
	    arr[row + 1][col + 1] = arr[row][col] = s[row];
	    arr[row + 1][col] = arr[row][col + 1] = s[row + 1];
	    return;
	} else {
	    buildMatrix(arr, s, row, col, length / 2);
	    buildMatrix(arr, s, row + length / 2, col, length / 2);
	    copyMatrix(arr, row, col, row + length / 2, col + length / 2,
		    length / 2);
	    copyMatrix(arr, row + length / 2, col, row, col + length / 2,
		    length / 2);
	}
    }

    public static void copyMatrix(char[][] arr, int i1, int j1, int i2, int j2,
	    int length) {
	for (int i = 0; i < length; i++) {
	    for (int j = 0; j < length; j++) {
		arr[i2 + i][j2 + j] = arr[i1 + i][j1 + j];
	    }
	}
    }
}
