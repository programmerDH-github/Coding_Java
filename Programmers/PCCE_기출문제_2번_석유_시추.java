package Programmers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PCCE_기출문제_2번_석유_시추 {
    static int n,m;
    static boolean[][] visited;
    static int[] oil;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) {
        int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};              // result = 9
        // int[][] land = {{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}};    // result = 16

        n = land.length;
        m = land[0].length;
        oil = new int[m];
        visited = new boolean[n][m];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(land[j][i] == 1 && !visited[j][i]) {
                    bfs(j,i,land);
                }
            }
        }

        int answer = 0;
        for(int o : oil) {
            answer = Math.max(answer,o);
        }
        
        System.out.println(answer);

    }

    static void bfs(int x, int y, int[][] land) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;

        int count = 1;
        Set<Integer> set = new HashSet<>();
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            set.add(now[1]);

            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx < n && nx >= 0 && ny < m && ny >= 0 && land[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    count++;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }

        for(int s : set) oil[s] += count;

    }

}
