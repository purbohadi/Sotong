package com.sotong.easy;

/*

 In Practice, You should use the statndard input/output
 in order to receive a score properly.
 Do not use file input and output. Please be very careful. 

 */

import java.security.KeyStore.Builder;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.lang.reflect.Array;

class SkyMap {

    static int[][] data;
    static int[][] visitedMatrix;
    static int N;

    static int stars = 0;

    static int AnswerN;

    public static void main(String args[]) throws Exception {
	Scanner sc = new Scanner(System.in);
	sc = new Scanner(new FileInputStream("src/input/skymap_input.txt"));
	int testCases = sc.nextInt();

	for (int i = 0; i < testCases; i++) {
	    N = sc.nextInt();

	    data = new int[N][N];
	    visitedMatrix = new int[N][N];

	    for (int j = 0; j < N; j++) {
		for (int k = 0; k < N; k++) {
		    data[j][k] = sc.nextInt();
		    visitedMatrix[j][k] = 0;
		}
	    }

	    int mapId = 1;
	    int maxStars = 0;
	    stars = 0;
	    for (int j = 0; j < N; j++) {
		for (int k = 0; k < N; k++) {
		    if (visitedMatrix[j][k] == 0 && data[j][k] == 1) {

			findMap(j, k, mapId);
			mapId++;
			if (stars > maxStars) {
			    maxStars = stars;
			}
			stars = 0;

		    }
		}
	    }

	    System.out.println(mapId - 1 + " " + maxStars);

	}
    }

    private static void findMap(int i, int j, int id) {

	visitedMatrix[i][j] = 1;
	stars++;
	if (i - 1 >= 0 && visitedMatrix[i - 1][j] == 0 && data[i - 1][j] == 1) {// up
	    findMap(i - 1, j, id);
	}
	if (i + 1 < N && visitedMatrix[i + 1][j] == 0 && data[i + 1][j] == 1) {// bottom
	    findMap(i + 1, j, id);
	}
	if (j - 1 >= 0 && visitedMatrix[i][j - 1] == 0 && data[i][j - 1] == 1) {// left
	    findMap(i, j - 1, id);
	}
	if (j + 1 < N && visitedMatrix[i][j + 1] == 0 && data[i][j + 1] == 1) {// right
	    findMap(i, j + 1, id);
	}

    }
}
