package com.sotong.normal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GalaxyPhoneBoothReserve {

    private static int[][] data;
    static int[][] visitedMatrix;
    static int[] groups;
    static int N;

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	try {
	    sc = new Scanner(new FileInputStream(
		    "src/input/galaxyphone_input.txt"));
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

		int s0 = 0;
		int s1 = 0;
		int s2 = 0;
		int s3 = 0;
		int s4 = 0;
		int s5 = 0;
		groups = new int[6];		
		for (int x = 0; x < N; x++) {
		    for (int y = 0; y < N; y++) {

			switch (data[x][y]) {
			case 0:
			    s0++;
			    groups[0] = s0;
			    data[x][y] = -1;
			    foundOne(x, y, data, 0);
			    
			    break;
			case 1:
			    s1++;
			    groups[1] = s1;
			    data[x][y] = -1;
			    foundOne(x, y, data, 1);
			    break;
			case 2:
			    s2++;
			    groups[2] = s2;
			    data[x][y] = -1;
			    foundOne(x, y, data, 2);
			    break;
			case 3:
			    s3++;
			    groups[3] = s3;
			    data[x][y] = -1;
			    foundOne(x, y, data, 3);
			    break;
			case 4:
			    s4++;
			    groups[4] = s4;
			    data[x][y] = -1;
			    foundOne(x, y, data, 4);
			    break;
			case 5:
			    s5++;
			    groups[5] = s5;
			    data[x][y] = -1;
			    foundOne(x, y, data, 5);
			    break;
			default:
			    break;
			}

		    }
		}
		
		int Answer = 0;
		
		for (int j = 0; j < 6; j++) {
		    System.out.print(groups[j] + " ");
		    Answer+=groups[j];
		}
		
		System.out.print(" Total :  "+ Answer);
		System.out.println();

	    }

	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public static void foundOne(int x, int y, int[][] data, int model) {
	// up
	if (x > 0) {
	    int index = x;
	    index--;
	    if (data[index][y] == model) {
		data[index][y] = -1;
		foundOne(index, y, data, model);
	    }
	}

	// down
	if (x < N - 1) {
	    int index = x;
	    index++;
	    if (data[index][y] == model) {
		data[index][y] = -1;
		foundOne(index, y, data, model);
	    }
	}

	// left
	if (y > 0) {
	    int index = y;
	    index--;
	    if (data[x][index] == model) {
		data[x][index] = -1;
		foundOne(x, index, data, model);
	    }
	}

	// right
	if (y < N - 1) {
	    int index = y;
	    index++;
	    if (data[x][index] == model) {
		data[x][index] = -1;
		foundOne(x, index, data, model);
	    }
	}
	
	
    }

}

class Group{
    private int[][] members;
    private int phoneType=0;
    
    public Group(int countMembers) {
	// TODO Auto-generated constructor stub
	members = new int[countMembers][2];
    }
    
    public void addMembers(int[][] items){
	members = items;
    }
    
    public void setType(int type){
	this.phoneType = type;
    }
    
    
}



