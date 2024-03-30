import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_15655 {
    static int[] arr,numbers;
    static int N,M;
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
        dfs(0,0);

        

        System.out.println(sb);

    }

    static void dfs(int index, int depth) {
        if(depth == M) {
            for(int i = 0; i < depth; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = index; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = numbers[i];
                dfs(i+1, depth+1);
                visited[i] = false;
            }
        }
    }
}
