import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_Joon_17952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int score = 0;
        int time = 0;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            if(input.equals("0")) {
                if(stack.isEmpty() && score == 0) {
                    continue;
                }
            }
            else {
                String[] mission = input.split(" ");
                if(score == 0) {
                    score = Integer.parseInt(mission[1]);
                    time = Integer.parseInt(mission[2]);
                }
                else {
                    stack.push(score);
                    stack.push(time);

                    score = Integer.parseInt(mission[1]);
                    time = Integer.parseInt(mission[2]);
                }                    
            }

            time--;

            if(time == 0) {
                sum += score;
                score = 0;

                if(!stack.isEmpty()) {
                    time = stack.pop();
                    score = stack.pop();
                }
            }
        }

        System.out.println(sum);

    }   
}
