import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_8370 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n1 = Integer.parseInt(input[0]);
        int k1 = Integer.parseInt(input[1]);
        int n2 = Integer.parseInt(input[2]);
        int k2 = Integer.parseInt(input[3]);

        System.out.println(n1*k1 + n2*k2);

    }
}
