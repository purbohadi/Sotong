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

//	static int[][] skyMatrix;
//	static int[][] visitedMatrix;
//	static int matLen;
//
//	static int stars = 0;
	
	static int AnswerN;
	static String tree;
	static int k;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		 sc = new Scanner(new FileInputStream("input.txt"));
		int testCases = sc.nextInt();

		for (int i = 0; i < testCases; i++) {
			k=sc.nextInt();
			tree=sc.next();
//			matLen = sc.nextInt();
//
//			skyMatrix = new int[matLen][matLen];
//			visitedMatrix = new int[matLen][matLen];
//
//			for (int j = 0; j < matLen; j++) {
//				for (int k = 0; k < matLen; k++) {
//					skyMatrix[j][k] = sc.nextInt();
//					visitedMatrix[j][k] = 0;
//				}
//			}
//
//			int mapId = 1;
//			int maxStars = 0;
//			stars = 0;
//			for (int j = 0; j < matLen; j++) {
//				for (int k = 0; k < matLen; k++) {
//					if (visitedMatrix[j][k] == 0 && skyMatrix[j][k] == 1) {
//
//						findMap(j, k, mapId);
//						mapId++;
//						if (stars > maxStars) {
//							maxStars = stars;
//						}
//						stars = 0;
//
//					}
//				}
//			}
//
//			System.out.println(mapId - 1 + " " + maxStars);
			
			char[] trees = tree.toCharArray();
			int deep = -1;
			for (int x=0;i<trees.length;i++) {
				if (trees[x] == '(') {
					deep++;
				} else if (trees[x] == ')') {
					deep--;
				}
				if (deep == k) {
					AnswerN += Integer.parseInt("" + trees[x]);
				}
			}
			
			System.out.println("# " + AnswerN);

		}
	}
//	
//	public static void buildNode(char[] tree) {
////		ArrayList<int[]> nodes = new ArrayList<int[]>();
//		int deep = -1;
//		for (int i=0;i<tree.length;i++) {
//			if (tree[i] == '(') {
//				deep++;
//			} else if (tree[i] == ')') {
//				deep--;
////			} else {
////				nodes.add(new int[]{deep, Integer.parseInt("" + tree[i])});
//			}
//			if (deep == k) {
//				AnswerN += Integer.parseInt("" + tree[i]);
//			}
//		}
//	}
//
//	private static void findMap(int i, int j, int id) {
//
//		visitedMatrix[i][j] = 1;
//		stars++;
//		if (i - 1 >= 0 && visitedMatrix[i - 1][j] == 0
//				&& skyMatrix[i - 1][j] == 1) {//up
//			findMap(i - 1, j, id);
//		}
//		if (i + 1 < matLen && visitedMatrix[i + 1][j] == 0
//				&& skyMatrix[i + 1][j] == 1) {//bottom
//			findMap(i + 1, j, id);
//		}
//		if (j - 1 >= 0 && visitedMatrix[i][j - 1] == 0
//				&& skyMatrix[i][j - 1] == 1) {//left
//			findMap(i, j - 1, id);
//		}
//		if (j + 1 < matLen && visitedMatrix[i][j + 1] == 0
//				&& skyMatrix[i][j + 1] == 1) {//right
//			findMap(i, j + 1, id);
//		}
//
//	}
}
