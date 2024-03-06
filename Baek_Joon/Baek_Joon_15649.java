import java.io.*;

public class Baek_Joon_15649 {
    static int N,M;
    static boolean[] check;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String[] N_M = br.readLine().split(" ");
        N = Integer.parseInt(N_M[0]);
        M = Integer.parseInt(N_M[1]);

        check = new boolean[N+1];
        for(int i = 1; i <= N; i++) {
            check[i] = true;
            combination(N,0,i+" ");
            check[i] = false;
        }

        System.out.println(sb);

    }

    public static void combination(int n, int r, String str) {
        if(M-1 == r) {
            sb.append(str).append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!check[i]) {
                check[i] = true;
                combination(n, r+1, str + i +" ");
                check[i] = false;
            }
        }

    }
}
