package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 함께하는_효도 {

    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int max = 0;
    static int[][] map;
    static String[][] x_y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n_m = br.readLine().split(" ");
        n = Integer.parseInt(n_m[0]);
        m = Integer.parseInt(n_m[1]);

        map = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            String[] fruit = br.readLine().split(" ");
            for(int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(fruit[j-1]);
            }
        }

        x_y = new String[m][];
        int sum = 0;
        for(int i = 0; i < m; i++) {
            x_y[i] = br.readLine().split(" ");
            sum += map[Integer.parseInt(x_y[i][0])][Integer.parseInt(x_y[i][1])];
            map[Integer.parseInt(x_y[i][0])][Integer.parseInt(x_y[i][1])] = 0;
        }
        
        
        dfs(Integer.parseInt(x_y[0][0]), Integer.parseInt(x_y[0][1]), 0, sum, 0);

        System.out.println(max);
        
    }

    
    static void dfs(int x, int y, int count, int sum, int worker) {
        

        if(count == 3) {
            if(worker+1 < m) {
                dfs(Integer.parseInt(x_y[worker+1][0]),Integer.parseInt(x_y[worker+1][1]),0,sum,worker+1);
            }
            if(sum > max) {
                max = sum;
            }
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx > 0 && nx <= n && ny > 0 && ny <= n) {
                int value = map[nx][ny];
                map[nx][ny] = 0;
                dfs(nx,ny,count+1,sum+value,worker);
                map[nx][ny] = value;
            }
        }

    }
}
