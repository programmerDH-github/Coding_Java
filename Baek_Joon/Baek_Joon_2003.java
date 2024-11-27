import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        int[] numbers_sum = new int[N+1];
        String[] input = br.readLine().split(" ");
        for(int i = 1; i <= N; i++) {
            numbers_sum[i] = numbers_sum[i-1] + Integer.parseInt(input[i-1]);
        }

        int i = 0;
        int j = 0;
        int count = 0;
        while(j < N && i < N) {
            if(j == N && numbers_sum[j] - numbers_sum[i] < M) break;
            if(numbers_sum[j]-numbers_sum[i] == M) {
                i++;
                j++;
                count++;
            }
            else if(numbers_sum[j]-numbers_sum[i] > M) i++;
            else j++;
        }

        System.out.println(count);

    }
}
