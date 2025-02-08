import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

public class Baek_Joon_1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] A_B = br.readLine().split(" ");
        Arrays.sort(A_B, Collections.reverseOrder());

        long A = Long.parseLong(A_B[0]);
        long B = Long.parseLong(A_B[1]);

        long gdc = getGdc(A,B);
        for(int i = 0; i < gdc; i++) sb.append("1");
        
        System.out.println(sb);

    }

    static long getGdc(long a, long b) {
        if(a < b) {
            long temp = a;
            a = b;
            b = temp;
        }

        while(b > 0) {
            long temp = a%b;
            a = b;
            b = temp;
        }

        return a;

    }

}
