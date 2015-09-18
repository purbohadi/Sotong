package com.sotong.normal;
/*

In Practice, You should use the statndard input/output
in order to receive a score properly.
Do not use file input and output. Please be very careful. 

*/

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Partition {

	static int N;
	static int [] data = new int[10001];
	static int time;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		//sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			int i;
			N = sc.nextInt();
			
			for(i=1; i<=N; i++) {
				data[i] = sc.nextInt();
			}
			
			/**********************************
			 * Implement your algorithm here. *
			 **********************************/

            time = 0;
            for (i=2 ; i <=N ; i++) {
                Arrays.sort(data,i-1,N+1);
                data[i] = data[i] + data[i-1];
                time += data[i];
            }		
			// Print the answer to standard output(screen).
			System.out.println(time);
		}
	}
}
