import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_3046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] R1_S = br.readLine().split(" ");
        int R1 = Integer.parseInt(R1_S[0]);
        int S = Integer.parseInt(R1_S[1]);

        System.out.println(S*2-R1);

    }
}
