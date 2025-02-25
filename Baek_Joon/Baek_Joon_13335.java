import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n_w_L = br.readLine().split(" ");
        int n = Integer.parseInt(n_w_L[0]);
        int w = Integer.parseInt(n_w_L[1]);
        int L = Integer.parseInt(n_w_L[2]);

        Queue<Integer> truck = new LinkedList<>();
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) truck.add(Integer.parseInt(input[i]));

        int time = 0;
        int totalWeigth = 0;
        Queue<Integer> road = new LinkedList<>();
        for(int i = 0; i < w; i++) road.add(0);
        while(!truck.isEmpty()) {
            time++;
            totalWeigth -= road.poll();
            if(totalWeigth+truck.peek() <= L) {
                int weigth = truck.poll();
                totalWeigth += weigth;
                road.add(weigth);                
            }
            else {
                int weigth = 0;
                road.add(weigth);
            }

        }

        System.out.println(time+w);

    }
}
