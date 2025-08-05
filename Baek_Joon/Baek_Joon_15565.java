import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_K = br.readLine().split(" ");
        int N = Integer.parseInt(N_K[0]);
        int K = Integer.parseInt(N_K[1]);
        
        int[] doll = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            doll[i] = Integer.parseInt(input[i]);
        }        

        int left = 0;
        int right = -1;
        int count = 0;
        int min = Integer.MAX_VALUE;
        while(true) {
            if(count == K) {
                min = Math.min(right-left+1, min);

                if(doll[left] == 1) count--; 
                left++;                
            }
            else {
                if(right == N-1) break;
                right++;
                if(doll[right] == 1) count++;
            }        
        }

        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);

    }
}
