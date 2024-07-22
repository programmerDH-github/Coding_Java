import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Baek_Joon_9659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine());
        BigInteger two = new BigInteger("2");

        

        if(N.remainder(two).equals(BigInteger.ZERO)) System.out.println("CY");
        else System.out.println("SK");
    }
}
