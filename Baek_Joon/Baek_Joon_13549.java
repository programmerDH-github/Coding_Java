import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_K = br.readLine().split(" ");
        int N = Integer.parseInt(N_K[0]);
        int K = Integer.parseInt(N_K[1]);

        if(N == K || K % N == 0) {
            System.out.println(0);
            return;
        }
        if(N > K) {
            System.out.println(N-K);
            return;
        }

        int idx = 0;
        int time = 0;
        int curValue = 0;
        int nextValue = 0;
        while(true) {
            curValue = N*idx;
            nextValue = N*(idx+1);
                        
            if(curValue < K && nextValue > K) {
                if(K-curValue > nextValue-K) time = nextValue-K;
                else time = K-curValue;
                break;
            }

            idx++;

        }

        System.out.println(time);

    }   
}
