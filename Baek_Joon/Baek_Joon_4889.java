import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_Joon_4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int idx = 1;
        while (true) {
            String input = br.readLine();
            if(input.contains("-")) break;
            
            Stack<String> stack = new Stack<>();
            String[] arr = input.split("");
            for(int i = 0; i < arr.length; i++) {
                if(stack.isEmpty()) {
                    stack.push(arr[i]);
                }
                else if(arr[i].equals("}") && stack.peek().equals("{")) {
                    stack.pop();
                }
                else stack.push(arr[i]);
            }

            int answer = 0;
            while(!stack.isEmpty()) {
                String first = stack.pop();
                String second = stack.pop();
                if(first.equals("{")) answer++;
                if(second.equals("}")) answer++;
            }

            sb.append(idx+". ").append(answer).append("\n");
            idx++;

        }

        System.out.println(sb);

    }
}
