import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        int count = 0;
        if(N == 1) {
            count = 1;
        }
        else if(N < 3) {
            count = Math.min(4, (M+1)/2);
        }
        else {
            if(M < 7) {
                count = Math.min(4, M);
            }
            else {
                count = M - 2;
            }
        }
        
        System.out.println(count);

    }
}
