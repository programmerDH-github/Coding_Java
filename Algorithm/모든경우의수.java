package Algorithm;

public class 모든경우의수 {
	
	static boolean[] visit = new boolean[3];
	static int[] result = new int[3];
	static int[] arr = {1,2,3};
	
	public static void main(String[] args) {
		dfs(0);

	}

	public static void dfs(int n) {
		if(n == result.length) {
			for(int i = 0; i < arr.length; i++) {
				if(visit[i]) {
					System.out.print(arr[i]);
				}
			}System.out.println();
		}
		else {
			System.out.println("depth : " + n);
			visit[n] = true;
			result[n] = arr[n];
			dfs(n+1);
			visit[n] = false;
			dfs(n+1);
		}
	}
}
