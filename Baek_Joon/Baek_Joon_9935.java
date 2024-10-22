import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_Joon_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String explosion = br.readLine();
        
        
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if(stack.size() >= explosion.length()) {
                int count = 0;
                
                for(int j = 0; j < explosion.length(); j++) {
                    if(stack.get(stack.size() - explosion.length() + j) == explosion.charAt(j)) {
                        count++;
                    }
                }

                if(count == explosion.length()) {
                    for(int j = 0; j < explosion.length(); j++) {
                        stack.pop();
                    }
                }


            }

        }

        if(stack.isEmpty()) sb.append("FRULA");
        else {
            for(Character c : stack) sb.append(c);
        }

        System.out.println(sb);        

    }
}
