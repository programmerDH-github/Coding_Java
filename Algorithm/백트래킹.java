package Algorithm;

public class 백트래킹 {

	public static void main(String[] args) {
		int n = 4;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];
        
        for (int i = 1; i <= n; i++) {
            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
            combination(arr, visited, 0, n, i);
        }

	}
	
	static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
	    if(r == 0) {
	        for(int i = 0; i < n; i++) {
	        	if(visited[i]) {
	        		System.out.print(arr[i] + " ");
	        	}
	        }
	        System.out.println();
	        return;
	    } 

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        combination(arr, visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}

}
