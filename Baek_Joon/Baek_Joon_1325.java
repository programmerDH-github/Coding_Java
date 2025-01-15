import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek_Joon_1325 {
    static int N,M;
    static ArrayList<Integer>[] trust;
    static boolean[] visited;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_M = br.readLine().split(" ");
        N = Integer.parseInt(N_M[0]);
        M = Integer.parseInt(N_M[1]);

        trust = new ArrayList[N+1];
        for(int i = 1; i < N+1; i++) trust[i] = new ArrayList<Integer>();
        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            trust[A].add(B);
        }

        count = new int[N+1];
        for(int i = 1; i < N+1; i++) {
            visited = new boolean[N+1];
            dfs(i);
        }

        int max = 0;
        for(int i = 1; i < N+1; i++) if(count[i] > max) max = count[i];


        for(int i = 1; i < N+1; i++) {
           if(count[i] == max) sb.append(i).append(" ");
        }

        System.out.println(sb);
    

    }

    static void dfs(int start) {
        visited[start] = true;
        
        for(int i : trust[start]) {
            if(!visited[i]) {
                count[i]++;
                dfs(i);
            }
        }

    }

}
