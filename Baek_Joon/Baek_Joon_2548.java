import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_2548 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(numbers);
        
        if(N % 2 == 0) {
            System.out.println(numbers[N/2-1]);
        }
        else {
            System.out.println(numbers[N/2]);
        }

    }
}
