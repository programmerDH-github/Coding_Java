import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_28353 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_K = br.readLine().split(" ");
        int N = Integer.parseInt(N_K[0]);
        int K = Integer.parseInt(N_K[1]);

        int[] w = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            w[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(w);

        int left = 0;
        int right = N-1;
        int answer = 0;
        while(left < right) {
            if(w[left]+w[right] > K) {
                right--;
            }
            else {
                answer++;
                left++;
                right--;
            }
        }

        System.out.println(answer);

    }
}
