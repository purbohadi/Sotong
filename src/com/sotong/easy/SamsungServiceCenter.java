package com.sotong.easy;


/*

In Practice, You should use the statndard input/output
in order to receive a score properly.
Do not use file input and output. Please be very careful. 

*/

import java.util.Scanner;
import java.io.FileInputStream;

class SamsungServiceCenter{

	static int N,M,P;
	static int [][] data = new int[11][1001];
	static int [][] answer = new int[11][11];

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		//sc = new Scanner(new FileInputStream("sevices_cutomes"));

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			int i,j;
			N = sc.nextInt();
			M = sc.nextInt();
			P = sc.nextInt();
			
			for(i=1; i<=P; i++) {
				for(j=1; j<=N; j++) {
					data[i][j] = sc.nextInt();
				}
			}
			for(i=1; i<=P; i++) {
				answer[test_case][i]=1;
			}
			for(i=1;i<=P;i++){
				for(j=1;j<=N;j++){
					if(data[i][j]>M+j-1){
						answer[test_case][i]=0;
					}
					
				}
			}
			
			/**********************************
			 * Implement your algorithm here. *
			 **********************************/
			
			// Print the answer to standard output(screen).
			for(i=1; i<=P; i++) {
				System.out.print(answer[test_case][i]);
			}
			System.out.println();
		}
	}
}
