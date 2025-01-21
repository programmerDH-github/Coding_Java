import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_20300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        long[] number = new long[N];
        for(int i = 0; i < N; i++) {
            number[i] = Long.parseLong(input[i]);
        }
        Arrays.sort(number);

        if(N == 1) {
            System.out.println(number[0]);
            return;
        }

        if(N == 2) {
            System.out.println(number[0]+number[1]);
            return;
        }

        long max = 0;
        if(N % 2 == 0) {
            int front = 0;
            int end = N-1;
            max = 0;
            while(front < end) {
                if(max < number[front]+number[end]) max = number[front]+number[end];
                front++;
                end--;
            }
        }
        else {
            int front = 0;
            int end = N-2;
            max = number[N-1];
            while(front < end) {
                if(max < number[front]+number[end]) max = number[front]+number[end];
                front++;
                end--;
            }

        }

        System.out.println(max);

    }
}
