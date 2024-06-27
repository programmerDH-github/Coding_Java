import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        int[][] A = new int[N][M];
        for(int i = 0; i < N; i++) {
            String[] num = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(num[j]);
            }
        }

        String[] M_K = br.readLine().split(" ");
        M = Integer.parseInt(M_K[0]);
        int K = Integer.parseInt(M_K[1]);

        int[][] B = new int[M][K];
        for(int i = 0; i < M; i++) {
            String[] num = br.readLine().split(" ");
            for(int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(num[j]);
            }
        }

        int[][] C = new int[N][K];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < K; j++) {
                for(int k = 0; k < M; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < K; j++) {
                System.out.print(C[i][j] +" ");
            }
            System.out.println();
        }

    }
}
