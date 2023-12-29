import java.io.*;
import java.util.Stack;

public class Baek_Joon_10773 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < K; i++) {
            String number = br.readLine();
            if(number.equals("0")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(Integer.parseInt(number));
            }
        }

        int answer = 0;
        while(!stack.isEmpty()) {
            answer += stack.pop();
        }

        System.out.println(answer);
    }
}
