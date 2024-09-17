import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Baek_Joon_15353 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        BigInteger first = new BigInteger(input[0]);
        BigInteger second = new BigInteger(input[1]);

        System.out.println(first.add(second));
    }
}
