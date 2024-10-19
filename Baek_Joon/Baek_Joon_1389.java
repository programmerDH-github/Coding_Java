import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        int[][] user = new int[N][N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(user[i], 100_000_000);
            user[i][i] = 0;
        }

        for(int i = 0; i < M; i++) {
            String[] friend = br.readLine().split(" ");
            int x = Integer.parseInt(friend[0]);
            int y = Integer.parseInt(friend[1]);

            user[x-1][y-1] = 1;
            user[y-1][x-1] = 1;

        }

        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    user[i][j] = Math.min(user[i][j], user[i][k] + user[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int idx = 101;
        for(int i = 0; i < N; i++) {
            int sum = 0;
            for(int j = 0; j < N; j++) {
                sum += user[i][j];
            }
            if(min >= sum) {
                if(min > sum) {
                    min = sum;
                    idx = i;
                }
                else {
                    if(idx > i) idx = i;
                }                
            }
        }
        
        System.out.println(idx+1);

    }
}
