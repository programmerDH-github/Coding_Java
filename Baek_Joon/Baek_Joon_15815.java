import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_Joon_15815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            int first = 0;
            int second = 0;

            if(input.charAt(i) == '+') {
                first = stack.pop();
                second = stack.pop();
                stack.add(second+first);
            }
            else if(input.charAt(i) == '-') {
                first = stack.pop();
                second = stack.pop();
                stack.add(second-first);
            }
            else if(input.charAt(i) == '*') {
                first = stack.pop();
                second = stack.pop();
                stack.add(second*first);
            }
            else if(input.charAt(i) == '/') {
                first = stack.pop();
                second = stack.pop();
                stack.add(second/first);
            }
            else {
                stack.add(input.charAt(i) - '0');
            }
        }

        System.out.println(stack.pop());

    }
}
