import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek_Joon_14241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> slime = new PriorityQueue<>((o1,o2) -> o2-o1);
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            slime.add(Integer.parseInt(input[i]));
        }

        long answer = 0;
        while(slime.size() > 1) {
            int x = slime.poll();
            int y = slime.poll();

            answer += x*y;
            slime.add(x+y);
        }

        System.out.println(answer);

    }
}
