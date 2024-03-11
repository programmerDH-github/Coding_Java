import java.io.*;

public class Baek_Joon_15650 {
    static int N,M;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        N = Integer.parseInt(N_M[0]);
        M = Integer.parseInt(N_M[1]);

        arr = new int[M];
        visited = new boolean[N];
        dfs(0,0);        
    }
    public static void dfs(int index , int depth) {
        if(M == depth) {
            for(int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = index; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i+1;
                dfs(i + 1, depth+1);
                visited[i] = false;
            }
        }
    }
}
