import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_Joon_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();

            if(".".equals(str)) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < str.length(); i++) {
                Character word = str.charAt(i);

                if(word == '(') stack.push(word);
                else if(word == '[') stack.push(word);
                else if(word == ')') {
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    }
                    else stack.push(word);
                }
                else if(word == ']') {
                    if(!stack.isEmpty() && stack.peek() == '[') {    
                        stack.pop();
                    }
                    else stack.push(word);
                }
                
            }
            
            if(stack.empty()) sb.append("yes").append("\n");
            else sb.append("no").append("\n");

        }

        System.out.println(sb);

    }
}
