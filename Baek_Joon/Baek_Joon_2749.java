package Baek_Joon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_Joon_2749 {
	static long[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		
		
		int mod = 1000000;
		int p = 15 * mod / 10;	//피사노주기 15^(n-1)		
		dp = new long[p+1];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i <= n%p; i++) {
			dp[i] = dp[i-1]%mod + dp[i-2]%mod;
		}
		
		System.out.println(dp[(int)(n%p)]%mod);
		
	}
}