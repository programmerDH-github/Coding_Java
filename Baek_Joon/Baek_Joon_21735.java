import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_21735 {
    static int N, M, answer;
    static int[] snow;
    static int[] next = { 1, 2 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        N = Integer.parseInt(N_M[0]);
        M = Integer.parseInt(N_M[1]);

        snow = new int[N+1];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            snow[i] = Integer.parseInt(input[i-1]);
        }
        
        dfs(1, 0, 0);
        
        System.out.println(answer);

    }

    static void dfs(int size, int location, int time) {
        if (time == M || location >= N) {
            answer = Math.max(answer,size);
            return;
        }

        for (int i = 0; i < 2; i++) {            
            if (i == 0)
                dfs(size + snow[location+next[i]], location+next[i], time + 1);
            else
                dfs((size / 2) + snow[location+next[i]], location+next[i], time + 1);
            

        }

    }

}
