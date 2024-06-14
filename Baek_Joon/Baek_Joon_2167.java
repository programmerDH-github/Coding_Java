import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            String[] number = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(number[j]);
            }
        }

        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            String[] x_y = br.readLine().split(" ");
            int start_x = Integer.parseInt(x_y[0]);
            int start_y = Integer.parseInt(x_y[1]);
            int end_x = Integer.parseInt(x_y[2]);
            int end_y = Integer.parseInt(x_y[3]);
            int sum = 0;
            for(int j = start_x-1; j < end_x; j++) {
                for(int k = start_y-1; k < end_y; k++) {
                    sum += arr[j][k];
                }
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);

    }
    
}