package Baek_Joon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_1926 {
	static boolean[][] check;
	static int checkArea = 0, count = 0, area = 0;
	static int n, m;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		n = Integer.parseInt(NM[0]);
		m = Integer.parseInt(NM[1]);
		
		int[][] arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			
			for(int k = 0; k < m; k++) {				
				arr[i][k] = Integer.parseInt(str[k]);
			}
		}
		
		check = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 1 && !check[i][j]) {
					count++;
					//dfs(i,j,arr);
					bfs(i,j,arr);
					if(checkArea > area) area = checkArea;
					checkArea = 0;
				}
			}
		}
		
		System.out.println(count);
		System.out.println(area);
		
	}
	
	public static void dfs(int x, int y, int[][] arr) {	//dfs	
		checkArea++;
		check[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(0 <= nextX && nextX < n && 0 <= nextY && nextY < m && arr[nextX][nextY] == 1 && !check[nextX][nextY]) {
				dfs(nextX,nextY,arr);
			}
		}
	}
	
	public static void bfs(int x, int y, int[][] arr) {	//bfs
		check[x][y] = true;
		checkArea++;
		Queue<Integer> queueX = new LinkedList<>();
		Queue<Integer> queueY = new LinkedList<>();
		
		queueX.add(x);
		queueY.add(y);
		
		
		while(!queueX.isEmpty()) {
			x = queueX.poll();
			y = queueY.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if(0 <= nextX && nextX < n && 0 <= nextY && nextY < m && arr[nextX][nextY] == 1 && !check[nextX][nextY]) {
					checkArea++;
					check[nextX][nextY] = true;
					queueX.add(nextX);
					queueY.add(nextY);
				}
			}
		}
		
	}

}
