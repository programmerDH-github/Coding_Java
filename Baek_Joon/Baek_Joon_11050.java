import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_K = br.readLine().split(" ");
        int N = Integer.parseInt(N_K[0]);
        int K = Integer.parseInt(N_K[1]);

        System.out.println(combi(N, K));
    }

    public static int combi(int n, int k) {
        if(k == 0 || n == k) {
            return 1;
        }

        return combi(n-1, k) + combi(n-1, k-1);
    }
}
