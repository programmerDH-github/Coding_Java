import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            
            int[] numbers = new int[N];
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                numbers[j] = Integer.parseInt(input[j]);
            }            

            long answer = 0;
            int max = 0;

            for(int j = N-1; j >= 0; j--) {
                if(numbers[j] > max) {
                    max = numbers[j];
                }
                else {
                    answer += max - numbers[j];
                }
            }

            sb.append(answer).append("\n");

        }

        System.out.println(sb);

    }
}
