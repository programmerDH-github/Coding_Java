import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_13241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] A_B = br.readLine().split(" ");
        long A = Integer.parseInt(A_B[0]);
        long B = Integer.parseInt(A_B[1]);

        System.out.println((A*B)/gcd(A, B));

    }
    
    static long gcd(long a, long b) {
        if(a < b) {
            long tmep = a;
            a = b;
            b = tmep;
        }

        while(b > 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;

    }
}
