import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_Joon_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        String[] stick = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < stick.length; i++) {
            if(stick[i].equals("(")) {
                stack.push(stick[i]);
            }
            else {
                stack.pop(); 
                if(stick[i-1].equals("(")) answer += stack.size();
                else answer++;                               
            }

        }

        System.out.println(answer);

    }
}
