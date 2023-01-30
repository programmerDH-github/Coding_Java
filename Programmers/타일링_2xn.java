package Programmers;

public class ≈∏¿œ∏µ_2xn {

	public static void main(String[] args) {
		int n = 4;
		
		int[] arr = new int[n+1];
		
		arr[1] = 1;
		arr[2] = 2;
		
		for(int i = 3; i <= n; i++) {
			arr[i] = (arr[i-1] + arr[i-2]) % 1000000007;
		}
		
		System.out.println(arr[n]);
	}
}
