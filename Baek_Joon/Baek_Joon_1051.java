import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            String[] number = br.readLine().split(""); 
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(number[j]);
            }
        }

        int max = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int target = arr[i][j];
                int count = 1;
                int answer = 0;
                while(true) {
                    int ni = i+count;
                    int nj = j+count;

                    if(ni >= N || nj >= M) break;

                    if(arr[ni][j] == target && arr[i][nj] == target && arr[ni][nj] == target) {
                        answer = (count+1) * (count+1);
                    }

                    count++;
                    
                }

                if(max < answer) max = answer;
            }
        }
        
        System.out.println(max);

    }
}
