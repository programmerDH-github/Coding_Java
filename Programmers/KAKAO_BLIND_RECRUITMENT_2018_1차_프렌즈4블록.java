package Programmers;

import java.util.*;

public class KAKAO_BLIND_RECRUITMENT_2018_1차_프렌즈4블록 {

	public static void main(String[] args) {
		int m = 6;
		int n = 6;
		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		boolean[][] visited;
		char[][] copy = new char[m][n];
		int answer = 0;
		
		for(int i = 0; i < m; i++) {
			copy[i] = board[i].toCharArray();
		}
		
		boolean flag = true;
		
		while(flag) {
			visited = new boolean[m][n];
			
			flag = false;
			for(int i = 0; i < m-1; i++) {
				for(int j = 0; j < n-1; j++) {
					char check = copy[i][j];
					if(check == '-') continue;
					if(copy[i+1][j] == check && copy[i][j+1] == check && copy[i+1][j+1] == check) {
						visited[i][j] = true;
						visited[i+1][j] = true;
						visited[i][j+1] = true;
						visited[i+1][j+1] = true;
						flag = true;
					}
				}
			}
			
			answer += conversion(copy, visited, m, n);
			
		}
		
		System.out.println(answer);

	}
	
	public static int conversion(char[][] copy, boolean[][] visited, int m, int n) {
		int count = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(visited[i][j] && copy[i][j] != '-') {
					copy[i][j] = '-';
					count++;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			Queue<Character> queue = new LinkedList<>();
			
			for(int j = m-1; j >= 0; j--) {
				if(copy[j][i] == '-') continue;
				else queue.add(copy[j][i]);
			}
			
			int idx = m-1;
			while(!queue.isEmpty()) {
				copy[idx--][i] = queue.poll();
			}
			
			for(int j = idx; j >= 0; j--) {
				copy[j][i] = '-';
			}
		}
		
		return count;
	}

}
