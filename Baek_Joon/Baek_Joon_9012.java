import java.io.*;
import java.util.Stack;

public class Baek_Joon_9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        
        for(int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<>();
            String VPS = br.readLine();
            if(VPS.length() % 2 != 0) {
                System.out.println("NO");
                continue;
            }

            for(int j = 0; j < VPS.length(); j++) {
                if(VPS.charAt(j) == '(') {
                    stack.add('(');
                }
                else {
                    if(stack.isEmpty()) {
                        stack.add('N');
                        break;
                    }
                    
                    stack.pop();
                }
            }
            if(!stack.isEmpty()) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
