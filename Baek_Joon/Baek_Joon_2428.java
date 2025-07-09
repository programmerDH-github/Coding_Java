import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_2428 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] F = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) F[i] = Integer.parseInt(input[i]);

        Arrays.sort(F);
        long answer = 0;
        for(int i = 0; i < N-1; i++) {
            int left = i+1;
            int right = N;
            
            while(left < right) {
                int mid = (left+right)/2;
                
                if(F[i] >= F[mid]*0.9) {
                    left = mid+1;
                }
                else {
                    right = mid;
                }

            }
            answer += left-i-1;
        }

        System.out.println(answer);

    }
}
