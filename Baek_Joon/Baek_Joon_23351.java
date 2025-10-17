import java.util.PriorityQueue;
import java.util.Scanner;

public class Baek_Joon_23351 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            pq.offer(K);
        }

        int water = 0;        
        int day = 1;
        while(pq.peek()-water > 0) {
            
            int watering = 0;
            while(watering < A) {
                pq.offer(pq.poll()+B);
                watering++;
            }

            water++;
            day++;
        }
        
        System.out.println(day-1);

    }
}
