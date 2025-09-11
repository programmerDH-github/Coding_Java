import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_28438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_M_Q = br.readLine().split(" ");
        int N = Integer.parseInt(N_M_Q[0]);
        int M = Integer.parseInt(N_M_Q[1]);
        int Q = Integer.parseInt(N_M_Q[2]);

        int[][] map = new int[N+1][M+1];

        String[] order = new String[Q];        
        for(int i = 0; i < Q; i++) {
            order[i] = br.readLine();
        }

        Arrays.sort(order);

        int idx = 0;
        int[] row = new int[N+1];
        while(idx < Q) {
            String[] input = order[idx].split(" ");
            int r = Integer.parseInt(input[1]);
            int v = Integer.parseInt(input[2]);
            
            if(input[0].equals("2")) break;

            row[r] += v;

            idx++;
        }

        int[] cell = new int[M+1];
        while(idx < Q) {
            String[] input = order[idx].split(" ");
            int c = Integer.parseInt(input[1]);
            int v = Integer.parseInt(input[2]);
            

            cell[c] += v;

            idx++;
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                map[i][j] += row[i]+cell[j];
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
