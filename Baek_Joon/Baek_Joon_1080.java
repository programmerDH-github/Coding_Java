import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] targetArr = new int[N][M];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                targetArr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int answer = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] != targetArr[i][j]) {
                    if(i+2 < N && j+2 < M) {
                        for(int k = i; k <= i+2; k++) {
                            for(int z = j; z <= j+2; z++) {
                                arr[k][z] = (arr[k][z] + 1) % 2;
                            }
                        }
                        answer++;
                    }
                    else {
                        System.out.println(-1);
                    return;
                    }
                }
            }
        }

        System.out.println(answer);

    }
}
