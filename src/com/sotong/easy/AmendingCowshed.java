package com.sotong.easy;
//package Practice;


//In Practice, You should use the statndard input/output
//in order to receive a score properly.
//Do not use file input and output. Please be very careful. 

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;


class AmendingCowshed
{
	static int M,N,C;
	static int [] data = new int[205];
	static int Answer;
	static int[] arr;
	static int k;

	public static void main(String args[]) throws Exception	
	{
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("src/input/amendingCowshed.txt"));

		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) 
		{
			M = sc.nextInt();
			N = sc.nextInt();
			C = sc.nextInt();
			data = new int[C];
			//System.out.println(M + " " + N + " " + C);

			if(C==0)
			{
				System.out.println(C);
				continue;
			}
				
			for(int i=0;i<C;i++)
			{
				data[i] = sc.nextInt();
			}
			
			Arrays.sort(data);
			
			if(M==1)
			{
				Answer = cost(0,C-1);
			}
			else if(M>=C)
			{
				Answer = C;
			}
			else
			{
				arr = new int[C-1];
				k = 0;
				Answer = cost(0,C-1);
				/**********************************
				*  Implement your algorithm here. *
				***********************************/
				//split(0, C-1, M-1, cost(0, C-1));
				
				for(int i=0;i<C-1;i++)
				{
					arr[i] = data[i+1] - data[i] - 1;
				}
				
				Arrays.sort(arr);
				
				for(int i=M-1, j=C-2;i>0;i--)
				{
					Answer -= arr[j--];
				}
			}
			// Print the answer to standard output(screen).
			System.out.println(Answer);
		}
	}	
	
	public static int cost(int i, int j)
	{
		return (data[j] - data[i] + 1);
	}
}