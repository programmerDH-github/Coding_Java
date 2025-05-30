import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < N*2; i++) {
            String input = br.readLine();
            if(queue.contains(input)) {
                if(!queue.peek().equals(input)) {
                    answer++;
                    queue.remove(input);
                }
                else queue.poll();
            }
            else {
                queue.add(input);
            }
        }

        System.out.println(answer);

    }
}
