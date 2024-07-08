import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_23971 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] H_W_N_M = br.readLine().split(" ");
        int H = Integer.parseInt(H_W_N_M[0]);
        int W = Integer.parseInt(H_W_N_M[1]);
        int N = Integer.parseInt(H_W_N_M[2]);
        int M = Integer.parseInt(H_W_N_M[3]);

        System.out.println(((H-1)/(N+1)+1)*((W-1)/(M+1)+1));

    }
}
