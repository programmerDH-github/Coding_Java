import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_10837 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        for(int i = 0; i < C; i++) {
            String[] M_N = br.readLine().split(" ");
            int M = Integer.parseInt(M_N[0]);
            int N = Integer.parseInt(M_N[1]);

            if(M == N) {
                sb.append(1).append("\n");
            }
            else if(M > N){
                if(M-N <= K-M+2) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else {
                if(N-M <= K-N+1) sb.append(1).append("\n");
                else  sb.append(0).append("\n");                
            }

        }
        
        System.out.println(sb);

    }
}
