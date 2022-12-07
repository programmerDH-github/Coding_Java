package Algorithm;

public class DP {
	
	static long[] arr = new long[101];
	public static void main(String[] args) {
		
		System.out.println(dp(100));

	}
	
	public static long dp(int n) {
		if(n == 0) return 0;
		else if(n == 1) return 1;
		else if(arr[n] != 0) return arr[n];
		else {
			// 메모이제이션
			return arr[n] = dp(n-1) + dp(n-2);
		}
	}

}
