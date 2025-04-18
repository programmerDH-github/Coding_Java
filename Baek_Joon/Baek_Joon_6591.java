import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_6591 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String[] input = br.readLine().split(" ");

            long N = Long.parseLong(input[0]);
            long K = Long.parseLong(input[1]);

            if(N == 0 && K == 0) {
                break;
            }
            
            long answer = 1;
            for(int i = 1; i <= K; i++) {
                answer *= N--;
                answer /= i;
            }

            sb.append(answer).append("\n");

        }

        System.out.println(sb);

    }
}
