import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_1740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        Queue<Long> queue = new LinkedList<>();
        while(N != 0) {
            queue.offer(N % 2);
            N /= 2;
        }
        
        long answer = 0;
        long multiples = 1;

        while (!queue.isEmpty()) {
            answer += queue.poll() * multiples;
            multiples *= 3;
        }

        System.out.println(answer);

    }
}
