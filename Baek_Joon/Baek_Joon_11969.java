import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_11969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_Q = br.readLine().split(" ");
        int N = Integer.parseInt(N_Q[0]);
        int Q = Integer.parseInt(N_Q[1]);

        int[][] count = new int[N+1][3];
        for(int i = 1; i <= N; i++) {
            int input = Integer.parseInt(br.readLine());
            count[i][0] = count[i-1][0];
            count[i][1] = count[i-1][1];
            count[i][2] = count[i-1][2];

            count[i][input-1]++;

        }

        for(int i = 0; i < Q; i++) {
            String[] a_b = br.readLine().split(" ");
            int a = Integer.parseInt(a_b[0]);
            int b = Integer.parseInt(a_b[1]);

            sb.append(count[b][0]-count[a-1][0]+" ").append(count[b][1]-count[a-1][1]+" ").append(count[b][2]-count[a-1][2]+"\n");

        }
        
        System.out.println(sb);

    }
}
