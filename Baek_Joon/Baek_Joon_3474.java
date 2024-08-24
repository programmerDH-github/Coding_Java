import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_3474 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            
            int answer = 0;
            while(N > 0) {
                answer += N / 5;
                N /= 5;
            }

            sb.append(answer).append("\n");

        }

        System.out.println(sb);

    }
}
