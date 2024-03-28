import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String[] A_B = br.readLine().split(" ");
            int A = Integer.parseInt(A_B[0]);
            int B = Integer.parseInt(A_B[1]);

            if(A > B) System.out.println(lcm(A, B));
            else System.out.println(lcm(B, A));
        }
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b); 
    }

    public static int lcm(int a, int b) {
        return a*b / gcd(a, b);
    }
}
