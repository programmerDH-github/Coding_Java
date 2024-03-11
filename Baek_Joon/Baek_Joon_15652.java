import java.io.*;

public class Baek_Joon_15652 {
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        arr = new int[M];
        dfs(N,M,0,0);

    }

    public static void dfs(int N, int M, int start, int depth) {
        if(depth == M) {
            for(int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < N; i++) {
            arr[depth] = i+1;
            dfs(N, M, i, depth+1);
        }
    }
}
