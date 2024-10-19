import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek_Joon_1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        

        PriorityQueue<int[]> problems = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0]) return o2[1] - o1[1];
            return o1[0] - o2[0];
        });

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int deadline = Integer.parseInt(input[0]);
            int amount = Integer.parseInt(input[1]);

            problems.offer(new int[]{deadline,amount});
        }
        
        PriorityQueue<Integer> answers = new PriorityQueue<>();
        while(!problems.isEmpty()) {
            int[] problem = problems.poll();
            int deadline = problem[0];
            int amount = problem[1];

            if(answers.size() < deadline) {
                answers.offer(amount);
            }
            else {
                if(answers.peek() < amount) {
                    answers.poll();
                    answers.offer(amount);
                } 
            }

        }

        int result = 0;
        for(int answer : answers) {
            result += answer;
        }

        System.out.println(result);
        
        

    }
}
