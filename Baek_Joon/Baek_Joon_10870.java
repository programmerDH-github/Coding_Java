package Baek_Joon;

import java.io.*;

public class Baek_Joon_10870 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] fibo = new int[n+1];
		
		
		for(int i = 0; i <= n; i++) {
			if(i == 0) fibo[0] = 0;
			else if(i == 1) fibo[1] = 1;
			else fibo[i] = fibo[i-1] + fibo[i-2];
		}
		System.out.println(fibo[n]);
	}

}
