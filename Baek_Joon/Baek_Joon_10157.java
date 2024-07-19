import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_10157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] C_R = br.readLine().split(" ");
        int C = Integer.parseInt(C_R[0]);
        int R = Integer.parseInt(C_R[1]);
        int K = Integer.parseInt(br.readLine());

        int[][] seat = new int[R][C];

        if(C*R < K) {
            System.out.println(0);
            return;
        }

        int x = 0;
        int y = 0;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int num = 1;
        int idx = 0;
        while(K != num) {
            seat[x][y] = num;

            int nx = x + dx[idx];
            int ny = y + dy[idx];
            if(nx < R && nx >= 0 && ny < C && ny >= 0 && seat[nx][ny] == 0) {
                seat[nx][ny] = num;
            }
            else {
                idx = (idx+1) % 4;
                nx = x + dx[idx];
                ny = y + dy[idx];
            }
            x = nx;
            y = ny;
            num++;
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                System.out.print(seat[i][j]+"  ");
            }
            System.out.println();
        }

        System.out.println((y+1)+" "+(x+1));

    }
}
