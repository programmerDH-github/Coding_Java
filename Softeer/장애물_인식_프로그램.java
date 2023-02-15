package Softeer;

import java.util.*;
import java.io.*;

public class 장애물_인식_프로그램 {

	static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int block_sum = 0;
    static int block_count = 0;
    static ArrayList<Integer> arraylist = new ArrayList<>();
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    block_sum++;
                    block_count = 1;
                    dfs(i,j);
                    arraylist.add(block_count);
                }
            }
        }

        System.out.println(block_sum);
        Collections.sort(arraylist);
        for(int i = 0; i < arraylist.size(); i++) System.out.println(arraylist.get(i));

    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < map.length && ny >= 0 && ny < map.length && map[nx][ny] == 1 && !visited[nx][ny]) {
                block_count++;
                dfs(nx,ny);
            }
        }
    }

}
