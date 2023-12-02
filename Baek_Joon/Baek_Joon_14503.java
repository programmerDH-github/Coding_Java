import java.io.*;

public class Baek_Joon_14503 {
    static int[] dx = {-1,0,1,0};   //북동남서  0123
    static int[] dy = {0,1,0,-1};   //서남동북  3210
    static int[][] maps;
    static int N,M,r,c,d;
    static int answer = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] N_M = br.readLine().split(" ");
        N = Integer.parseInt(N_M[0]);
        M = Integer.parseInt(N_M[1]);

        maps = new int[N][M];

        String[] r_c_d = br.readLine().split(" ");
        r = Integer.parseInt(r_c_d[0]);
        c = Integer.parseInt(r_c_d[1]);
        d = Integer.parseInt(r_c_d[2]);

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(input[j]);                
            }
        }

        dfs(r,c,d);

        System.out.println(answer);

    }

    public static void dfs(int x, int y, int direct) {
        System.out.println(x+", "+y);
        maps[x][y] = -1;

        for(int i = 0; i < 4; i++) {
            direct = (direct + 3)%4;
            int nx = x + dx[direct];
            int ny = y + dy[direct];

            if(nx >= 0 && nx < N && ny >= 0 && ny < M && maps[nx][ny] == 0) {
                answer++;
                dfs(nx, ny, direct);

                return;
            } 
        }

        int back = (direct + 2)%4;
        int bx = x + dx[back];
        int by = y + dy[back];

        if(bx >= 0 && bx < N && by >= 0 && by < M && maps[bx][by] != 1) {
            dfs(bx,by,direct);
        }

    }

}