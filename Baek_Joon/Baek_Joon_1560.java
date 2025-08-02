import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Baek_Joon_1560 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        if(N.equals("0") || N.equals("1")) {
            System.out.println(N);
            return;
        }
        
        BigInteger two = new BigInteger("2");
        BigInteger bi = new BigInteger(N);
        BigInteger after;
        after = bi.subtract(BigInteger.ONE).multiply(two);

        System.out.println(after);

    }   
}
