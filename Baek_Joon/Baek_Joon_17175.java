import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_17175 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int divide = 1_000_000_007;

        int[] fibo = new int[51];
        fibo[0] = 1;
        fibo[1] = 1;
        for(int i = 2; i < 51; i++) {
            fibo[i] = (fibo[i-1] + fibo[i-2] + 1) % divide;
        }

        System.out.println(fibo[n]);

    }
}
