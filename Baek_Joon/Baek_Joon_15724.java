import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_15724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        int[][] arr = new int[N][M];
        int[][] prifixSum = new int[N+1][M+1];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                prifixSum[i][j] += prifixSum[i][j-1] + arr[i-1][j-1];
            }
        }

        int K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);

            long sum = 0;
            for(int j = x1; j <= x2; j++) {
                sum += prifixSum[j][y2] - prifixSum[j][y1-1];
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);

    }
}
