package com.sotong.easy;

import java.util.Scanner;

public class PlanningTour {

    static int N, M, Answer;
    static BidirectionalGraph graph;
    static String[] cities;
    static int[] path;

    public static void main(String args[]) throws Exception {
	Scanner sc = new Scanner(System.in);
	// sc = new Scanner(new FileInputStream("input.txt"));

	int T = sc.nextInt();
	for (int tc = 0; tc < T; tc++) {

	    Answer = 0;
	    N = sc.nextInt();
	    M = sc.nextInt();

	    graph = new BidirectionalGraph(N);
	    cities = new String[N];
	    for (int i = 0; i < N; i++) {
		cities[i] = sc.next();
	    }

	    sc.nextLine();
	    for (int i = 0; i < M; i++) {
		String line = sc.nextLine();
		String[] edges = line.split(" ");
		int u = -1, v = -1;
		for (int j = 0; j < N && (u < 0 || v < 0); j++) {
		    if (u < 0 && edges[0].equals(cities[j])) {
			u = j;
		    }
		    if (v < 0 && edges[1].equals(cities[j])) {
			v = j;
		    }
		}
		// if (u < v) {
		graph.addEdge(u, v);
		// } else {
		// graph.addEdge(v, u);
		// }
	    }
	    findMinimumTour();

	}
    }

    public static void findMinimumTour() {
	int[][] dp = new int[N][N];

	dp[0][0] = 1;

	for (int i = 0; i < N; i++) {
	    for (int j = i; j < N; j++) {
		int count = 0;

		for (int k = j; k >= 0; k--) {
		    if (graph.isEdge(k, j) && dp[i][k] > 0) {
			int temp = dp[i][k];
			if (i != j) {
			    temp++;
			}
			count = Math.max(temp, count);
		    } else if (i == j && dp[0][i] > count) {
			count = dp[0][i];
		    }
		}
		dp[i][j] = dp[j][i] = count;
	    }
	}
	System.out.println(dp[N - 1][N - 1]);

    }
}

class BidirectionalGraph {
    private boolean adjacencyMatrix[][];
    private int vertexCount;

    public BidirectionalGraph(int vCount) {
	this.vertexCount = vCount;
	this.adjacencyMatrix = new boolean[vertexCount][vertexCount];
    }

    public void addEdge(int i, int j) {
	if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
	    this.adjacencyMatrix[i][j] = true;
	    adjacencyMatrix[j][i] = true;
	}
    }

    public void removeEdge(int i, int j) {
	if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
	    this.adjacencyMatrix[i][j] = false;
	    adjacencyMatrix[j][i] = false;
	}
    }

    public boolean isEdge(int i, int j) {
	if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount)
	    return adjacencyMatrix[i][j];
	else
	    return false;
    }

}
