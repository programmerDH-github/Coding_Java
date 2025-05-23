import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_13171 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long A = Long.parseLong(br.readLine());
        long X = Long.parseLong(br.readLine());
        long mod = 1_000_000_007;        
        
        long[] arr = new long[64];        
        for(int i = 0; i < 64; i++) {
            if(i == 0) arr[i] = A;
            else arr[i] = (arr[i-1] * arr[i-1]) % mod;
        }

        String binaryString = Long.toBinaryString(X);
        long answer = 1;
        for(int i = 0; i < binaryString.length(); i++) {
            if(binaryString.charAt(i) == '1') answer =  (answer * arr[binaryString.length()-1-i])%mod;
        }

        System.out.println(answer);

    }
}
