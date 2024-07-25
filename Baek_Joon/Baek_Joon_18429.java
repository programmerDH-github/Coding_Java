import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_18429 {
    static int N,K;
    static int answer = 0;
    static boolean[] visited;
    static int[] exercise;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_K = br.readLine().split(" ");
        N = Integer.parseInt(N_K[0]);
        K = Integer.parseInt(N_K[1]);

        exercise = new int[N];
        visited = new boolean[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            exercise[i] = Integer.parseInt(input[i]);
        }

        dfs(500, 0);

        System.out.println(answer);

    }

    static void dfs(int weight, int day) {
        if(weight < 500) {
            return;
        }

        if(day == N) {
            answer++;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(weight-K+exercise[i], day+1);
                visited[i] = false;
            }
        }

    }

}
