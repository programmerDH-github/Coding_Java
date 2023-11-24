import java.util.*;
import java.io.*;

public class Baek_Joon_2667 {
    static int[][] maps;
    static boolean[][] visited;
    static ArrayList<Integer> arraylist = new ArrayList<>();
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        maps = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(str[j]);
            }
        }

        int apart_number = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(maps[i][j] != 0 && !visited[i][j]) {
                    apart_number++;
                    count = 0;
                    bfs(i,j,maps[i][j]);
                }
            }
        }
        
        Collections.sort(arraylist);
        System.out.println(apart_number);
        for(int i = 0; i < arraylist.size(); i++) {
            System.out.println(arraylist.get(i));
        }
        
        
    }

    public static void bfs (int x, int y, int current) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        count++;

        while(!queue.isEmpty()) {
            int cur_x = queue.peek()[0];
            int cur_y = queue.peek()[1];
            queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];

                if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps.length && !visited[nx][ny] && maps[nx][ny] == current) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny});
                    count++;                    
                }
            }
        }
        arraylist.add(count);

    }
}
