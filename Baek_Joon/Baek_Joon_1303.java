import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_1303 {
    static int N,M;
    static String[][] colors;
    static boolean[][] visited; 
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        N = Integer.parseInt(N_M[0]);
        M = Integer.parseInt(N_M[1]);

        colors = new String[M][N];
        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                colors[i][j] = input[j];
            }
        }

        visited = new boolean[M][N];
        int white = 0;
        int blue = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    if(colors[i][j].equals("W")) white += Math.pow(bfs(i,j,1,colors[i][j]),2);
                    else blue += Math.pow(bfs(i,j,1,colors[i][j]),2);
                }
            }
        }

        
        System.out.println(white+" "+blue);


    }

    static int bfs(int x, int y, int count, String color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] x_y = queue.poll();
            int curX = x_y[0];
            int curY = x_y[1];

            for(int i = 0; i < 4; i++) {
                int newX = curX + dx[i];
                int newY = curY + dy[i];

                if(newX >= 0 && newX < M && newY >= 0 && newY < N && colors[newX][newY].equals(color) && !visited[newX][newY]) {
                    queue.offer(new int[]{newX,newY});
                    visited[newX][newY] = true;
                    count++;                    
                }

            }
            

        }
        
        return count;
    }

}
