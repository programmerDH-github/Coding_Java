import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Baek_Joon_10610 {
    static String[] N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine().split("");

        Arrays.sort(N, Collections.reverseOrder());

        int sum = 0;
        for(int i = 0; i < N.length; i++) {
            sum += Integer.parseInt(N[i]);
        }

        if(Integer.parseInt(N[N.length-1]) != 0 || sum % 3 != 0) System.out.println(-1);
        else {
            for(String num : N) System.out.print(num);
        }

    }
}
