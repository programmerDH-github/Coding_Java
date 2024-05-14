import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_L = br.readLine().split(" ");
        int N = Integer.parseInt(N_L[0]);
        int L = Integer.parseInt(N_L[1]);

        int[] leaking = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        if(L == 1) {
            System.out.println(leaking.length);
            return;
        }

        int tape = 0;
        int number = leaking[0];
        for(int i = 0; i < leaking.length; i++) {
            if(i == 0) {
                tape++;
                number = leaking[i];
                continue;
            }

            if(leaking[i] - number < L) {
                continue;
            }
            else {  
                tape++;
                number = leaking[i];
            }
            
        }

        System.out.println(tape);

    }
}
