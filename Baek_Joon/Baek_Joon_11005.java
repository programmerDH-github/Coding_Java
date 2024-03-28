import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_Joon_11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_B = br.readLine().split(" ");
        int N = Integer.parseInt(N_B[0]);
        int B = Integer.parseInt(N_B[1]);

        Stack<Integer> stack = new Stack<>();
        while(N >= B) {
            stack.push(N%B);
            N = N / B;
        }
        stack.push(N);

        while(!stack.isEmpty()) {
            int number = stack.pop();
            if(number >= 10) {
                sb.append((char)(55+number));
            }
            else {
                sb.append(number);
            }
        }

        System.out.println(sb);
    }
}
