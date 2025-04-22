import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_Joon_2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_P = br.readLine().split(" ");
        int N = Integer.parseInt(N_P[0]);
        int P = Integer.parseInt(N_P[1]);

        Stack<Integer>[] stack = new Stack[7];
        for(int i = 1; i <= 6; i++) {
            stack[i] = new Stack<>();
        }

        int answer = 0;
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int p = Integer.parseInt(input[1]);

            if(stack[n].isEmpty() || stack[n].peek() < p) {
                answer++;
                stack[n].push(p);
            }
            else if(stack[n].peek() > p){
                while(!stack[n].isEmpty() && stack[n].peek() > p) {
                    stack[n].pop();
                    answer++;
                }

                if(stack[n].isEmpty() || stack[n].peek() != p) {
                    stack[n].push(p);
                    answer++;
                }
            }

        }

        System.out.println(answer);

    }
}
