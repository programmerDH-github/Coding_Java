import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_13251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int color = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(br.readLine());

        int[] shingle = new int[color];
        double all_count = 0;
        for(int i = 0; i < color; i++) {
            shingle[i] = Integer.parseInt(input[i]);
            all_count += shingle[i];
        }

        double answer = 0;
        for(int i = 0; i < color; i++) {            
            double sum = 1;
            double all = all_count;
            double current_count = shingle[i];
            for(int j = 0; j < K; j++) {
                sum *= current_count/all;
                current_count--;
                all--;
            }
            answer += sum;
        }

        System.out.println("answer : "+answer);

    }
}
