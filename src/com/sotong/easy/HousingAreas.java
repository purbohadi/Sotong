package com.sotong.easy;

import java.io.FileInputStream;
import java.util.Scanner;

public class HousingAreas {
    static int N = 0;

    public static void main(String args[]) throws Exception {
//	Scanner sc = new Scanner(System.in);
	Scanner sc = new Scanner(new FileInputStream("input.txt"));

	int T = sc.nextInt();
	for (int tc = 0; tc < T; tc++) {

	    N = sc.nextInt();
	    int[][] data = new int[N][N];

	    for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
		    data[i][j] = sc.nextInt();
		}
	    }

	    //

	    int Answer = 0;
	    for (int x = 0; x < N; x++) {
		for (int y = 0; y < N; y++) {
		    if (data[x][y] == 1) {
			Answer++;
			data[x][y] = 0;
			foundOne(x, y, data);
		    }
		}
	    }

	    System.out.println(Answer);
	}
    }

    /**********************************
     * Implement your algorithm here. *
     ***********************************/

    // Print the answer to standard output(screen).

    public static void foundOne(int x, int y, int[][] data) {
	// up
	if (x > 0) {
	    int index = x;
	    index--;
	    if (data[index][y] == 1) {
		data[index][y] = 0;
		foundOne(index, y, data);
	    }
	}

	// down
	if (x < N - 1) {
	    int index = x;
	    index++;
	    if (data[index][y] == 1) {
		data[index][y] = 0;
		foundOne(index, y, data);
	    }
	}

	// left
	if (y > 0) {
	    int index = y;
	    index--;
	    if (data[x][index] == 1) {
		data[x][index] = 0;
		foundOne(x, index, data);
	    }
	}

	// right
	if (y < N - 1) {
	    int index = y;
	    index++;
	    if (data[x][index] == 1) {
		data[x][index] = 0;
		foundOne(x, index, data);
	    }
	}
    }

}
