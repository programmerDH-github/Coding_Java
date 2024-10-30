import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_20115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        double[] drink = new double[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            drink[i] = Double.parseDouble(input[i]);    
        }

        Arrays.sort(drink);

        double answer = 0;
        for(int i = 0; i < N-1; i++) {
            answer += drink[i] / 2;
        }

        System.out.println(answer + drink[N-1]);

    }
}
