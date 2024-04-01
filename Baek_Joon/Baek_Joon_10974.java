import java.io.*;

public class Baek_Joon_10974 {
    static boolean[] visited;
    static int N;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        
        visited = new boolean[N];
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            visited[i] = true;
            arr[0] = i+1;
            dfs(1);
            visited[i] = false;
        }

        System.out.println(sb);

    }
    static void dfs(int depth) {

        if(depth == N) {
            for(int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i+1;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
