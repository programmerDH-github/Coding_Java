package Baek_Joon;

import java.io.*;
import java.math.*;

public class Baek_Joon_10826 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		BigInteger[] fibo = new BigInteger[n+1];
		
		
		for(int i = 0; i <= n; i++) {
			if(i == 0) fibo[0] = BigInteger.ZERO;
			else if(i == 1) fibo[1] = BigInteger.ONE;
			else fibo[i] = fibo[i-1].add(fibo[i-2]);
		}
		System.out.println(fibo[n]);
	}

}
