import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Baek_Joon_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Integer[] w = new Integer[N];
        for(int i = 0; i < N; i++) {
            w[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(w, Collections.reverseOrder());


        int max_weight = w[0];
        for(int i = 1; i < N; i++) {
            if(max_weight < w[i]*(i+1)) {
                max_weight = w[i]*(i+1);
            }
        }

        
        System.out.println(max_weight);

    }
}
