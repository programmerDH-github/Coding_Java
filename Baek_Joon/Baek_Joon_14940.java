import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_14940 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] n_m = br.readLine().split(" ");
        n = Integer.parseInt(n_m[0]);
        m = Integer.parseInt(n_m[1]);
        
        map = new int[n][m];
        visited = new boolean[n][m];
        int startX = 0;
        int startY = 0;
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);

                if(map[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        visited[startX][startY] = true;
        map[startX][startY] = 0;
        bfs(startX,startY);
        

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1 && !visited[i][j]) map[i][j] = -1; 
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }


    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];

            for(int i = 0; i < 4; i++) {
                int newX = nx + dx[i];
                int newY = ny + dy[i];
                
                if(newX < n && newX >= 0 && newY < m && newY >= 0 && !visited[newX][newY] && map[newX][newY] == 1) {
                    map[newX][newY] = map[nx][ny] + 1;
                    queue.add(new int[] {newX, newY});
                    visited[newX][newY] = true;
                }
                
            }
        }
    }

}