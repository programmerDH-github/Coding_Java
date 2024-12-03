import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_Joon_11899 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '(') {
                stack.push('(');
            }
            else {
                if(!stack.isEmpty()) stack.pop();
                else count++;
            }

        }

        System.out.println(count+stack.size());

    }
}
