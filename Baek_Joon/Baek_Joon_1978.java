import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1978 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] numbers = br.readLine().split(" ");
        int prime_count = 0;
        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(numbers[i]);

            if(number == 1) continue;
            if(number == 2) {
                prime_count++; continue;
            }
            for(int j = 2; j < number; j++) {
                if(number % j == 0) {
                    break;
                }
                if(j == number-1) prime_count++;
            }
        }
        System.out.println(prime_count);
    }
}
