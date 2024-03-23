import java.io.*;
import java.util.Arrays;

public class Baek_Joon_15654 {
    static int N,M;
    static int[] arr,numbers;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String[] N_M = br.readLine().split(" ");
        N = Integer.parseInt(N_M[0]);
        M = Integer.parseInt(N_M[1]);
        
        numbers = new int[N];
        visited = new boolean[N];
        String[] number = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(number[i]);
        }
        Arrays.sort(numbers);

        arr = new int[M];
        dfs(0);
        
        System.out.println(sb);

    }
    
    public static void dfs(int depth) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = numbers[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
