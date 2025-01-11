import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_Joon_2529 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        String[] input = br.readLine().split(" ");
        int number = 9;
        for(int i = 0; i < input.length; i++) {
            stack.push(number);
            number--;

            if(input[i].equals(">")) {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }

        }
        stack.push(number);
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.append("\n");

        number = 0;
        for(int i = 0; i < input.length; i++) {
            stack.push(number);
            number++;

            if(input[i].equals("<")) {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }

        }
        stack.push(number);
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);

    }
}
