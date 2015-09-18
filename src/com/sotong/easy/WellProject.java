package com.sotong.easy;

import java.util.Scanner;

public class WellProject {

    private static int N, Answer;
    private static WeightedGraph graph;

    public static void main(String args[]) throws Exception {
	Scanner sc = new Scanner(System.in);
	// sc = new Scanner(new FileInputStream("input.txt"));

	int T = sc.nextInt();
	for (int tc = 0; tc < T; tc++) {

	    Answer = 0;
	    N = sc.nextInt();
	    graph = new WeightedGraph(N);
	    for (int i = 0; i < N; i++) {
		sc.nextLine();
		for (int j = 0; j < N; j++) {
		    graph.addEdge(i, j, sc.nextInt());
		}
	    }

	    PrimsMST();

	}
    }

    public static void PrimsMST() {
	int[] parent = new int[N];
	int[] key = new int[N];
	boolean[] mstSet = new boolean[N];

	for (int i = 0; i < N; i++) {
	    key[i] = Integer.MAX_VALUE;
	    mstSet[i] = false;
	}

	key[0] = 0;// init key & parent
	parent[0] = -1;

	for (int count = 0; count < N - 1; count++) {
	    int u = minimumKey(key, mstSet);
	    mstSet[u] = true;

	    for (int v = 0; v < N; v++) {
		if (graph.getWeight(u, v) != 0 && !mstSet[v]
			&& graph.getWeight(u, v) < key[v]) {
		    parent[v] = u;
		    key[v] = graph.getWeight(u, v);
		}
	    }
	}
	printMST(parent);

    }

    public static int minimumKey(int[] key, boolean[] mstSet) {

	int min = Integer.MAX_VALUE;
	int min_idx = 0;

	for (int v = 0; v < N; v++) {
	    if (!mstSet[v] && key[v] <= min) {
		min = key[v];
		min_idx = v;
	    }
	}

	return min_idx;
    }

    public static void printMST(int[] parent) {
	for (int i = 1; i < N; i++) {
	    Answer += graph.getWeight(i, parent[i]);
	}
	System.out.println(Answer);
    }
}

class WeightedGraph {
    private int adjacencyMatrix[][];
    private int vertexCount;

    public WeightedGraph(int vCount) {
	this.vertexCount = vCount;
	this.adjacencyMatrix = new int[vertexCount][vertexCount];
    }

    public void addEdge(int i, int j, int weight) {
	if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
	    adjacencyMatrix[i][j] = weight;
	    adjacencyMatrix[j][i] = weight;
	}
    }

    public void removeEdge(int i, int j) {
	if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
	    // this.adjacencyMatrix[i][j] = weight;
	    // adjacencyMatrix[j][i] = false;
	}
    }

    public int getWeight(int i, int j) {
	return adjacencyMatrix[i][j];
    }

}
