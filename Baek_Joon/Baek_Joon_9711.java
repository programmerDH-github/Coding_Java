import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_9711 {
    static long[] numbers = new long[10001];
    static int P,Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String[] P_Q = br.readLine().split(" ");
            P = Integer.parseInt(P_Q[0]);
            Q = Integer.parseInt(P_Q[1]);
               
            long first = 1;
            long second = 1;
            long answer = 0;
            for(int j = 3; j <= P; j++) {
                answer = (first + second)%Q;
                first = second;
                second = answer;
            }
            if(P <= 2) answer = 1%Q;
            sb.append( "Case #"+(i+1)+": ").append(answer).append("\n");

        }

        System.out.println(sb);

    }
}
