import java.io.*;
import java.math.BigInteger;

public class Baek_Joon_10757 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] number = br.readLine().split(" ");
        BigInteger first = new BigInteger(number[0]);
        BigInteger second = new BigInteger(number[1]);

        System.out.println(first.add(second));
    }
}
