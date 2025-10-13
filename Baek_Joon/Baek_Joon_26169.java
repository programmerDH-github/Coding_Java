import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_26169 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean check = false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        map = new int[5][5];
        visited = new boolean[5][5];
        for(int i = 0; i < 5; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        String[] x_y = br.readLine().split(" ");
        int x = Integer.parseInt(x_y[0]);
        int y = Integer.parseInt(x_y[1]);

        visited[x][y] = true;
        dfs(x, y, 0, 0);

        if(check) System.out.println(1);
        else System.out.println(0);

    }

    static void dfs(int x, int y, int cost, int apple) {
        if(cost == 3) {
            if(apple >= 2) check = true;
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && map[nx][ny] != -1 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                if(map[nx][ny] == 1) dfs(nx, ny, cost+1, apple+1);
                else dfs(nx, ny, cost+1, apple);
                visited[nx][ny] = false;
            }

        }

    }

}
