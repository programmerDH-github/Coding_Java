package Programmers;

import java.util.*;

public class 게임_맵_최단거리 {
	static int answer = Integer.MAX_VALUE;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visited;
	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		visited = new boolean[maps.length][maps[0].length];
		visited[0][0] = true;
		
		//dfs(0,0,1,maps);
		bfs(0,0,1,maps);
		System.out.println(answer);
	}
	
	public static void dfs(int x, int y, int count, int[][] maps) {
		
		if(x == maps.length-1 && y == maps[0].length-1) {
			System.out.println(count);
			answer = Math.min(answer, count);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx <= maps.length-1 && ny >= 0 && ny <= maps[0].length-1 && !visited[nx][ny] && maps[nx][ny] == 1) {
				System.out.println("x : "+nx+", y : "+ny);
				visited[nx][ny] = true;
				dfs(nx,ny,count+1,maps);
				visited[nx][ny] = false;
			}
		}
	}
	
	public static void bfs(int x, int y, int count, int[][] maps) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			x = now[0];
			y = now[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx <= maps.length-1 && ny >= 0 && ny <= maps[0].length-1 && !visited[nx][ny] && maps[nx][ny] == 1) {
					visited[nx][ny] = true;
					maps[nx][ny] = maps[x][y]+1;
					queue.add(new int[] {nx,ny});
				}
			}
			
		}
		answer = maps[maps.length-1][maps[0].length-1];
	}
}
