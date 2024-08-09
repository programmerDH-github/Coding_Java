import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_11052 {
    static int[] D = new int[1001];
    static int[] P = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        
        for(int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(input[i-1]);
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= i; j++) {
                D[i] = Math.max(D[i], D[i-j]+P[j]);
            }
        }

        System.out.println(D[N]);

    }
}
