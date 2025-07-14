import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Baek_Joon_19638 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_H_T = br.readLine().split(" ");
        int N = Integer.parseInt(N_H_T[0]);
        int H = Integer.parseInt(N_H_T[1]);
        int T = Integer.parseInt(N_H_T[2]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < N; i++) pq.offer(Integer.parseInt(br.readLine()));

        boolean check = false;
        int min = 0;
        while(true) {
            if(pq.peek() < H) {
                check = true;
                break;
            }

            if(T == min) {
                check = false;
                break;
            }

            if(pq.peek() != 1) pq.offer(pq.poll()/2);
            min++;
        }

        if(check) {
            System.out.println("YES");
            System.out.println(min);
        }
        else {
            System.out.println("NO");
            System.out.println(pq.peek());
        }

    }
}
