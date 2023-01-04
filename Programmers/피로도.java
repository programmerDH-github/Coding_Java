package Programmers;

public class ÇÇ·Îµµ {
	static boolean[] check;
	static int answer = 0;
	public static void main(String[] args) {
		int k = 80;
		int[][] dungeons = {{80,20},{50,40},{30,10}};
		check = new boolean[dungeons.length];
		
		for(int i = 0; i < dungeons.length; i++) {
			check[i] = true;
			int num = k;
			if(k >= dungeons[i][0]) {
				dfs(dungeons, num-dungeons[i][1], 1, 0);
			}
			check[i] = false;
		}
		
		System.out.println(answer);

	}
	
	public static void dfs(int[][] dungeons, int num, int dongeon_count, int count) {
		if(count == dungeons.length-1) {
			if(answer < dongeon_count) answer = dongeon_count;
			return;
		}
		
		for(int i = 0; i < dungeons.length; i++) {
			if(!check[i] && num >= dungeons[i][0]) {
				check[i] = true;
				dfs(dungeons, num-dungeons[i][1], dongeon_count+1, count+1);
				check[i] = false;
			}
			else if(!check[i]){
				check[i] = true;
				dfs(dungeons, num, dongeon_count, count+1);
				check[i] = false;
			}
		}
		
	}
}
