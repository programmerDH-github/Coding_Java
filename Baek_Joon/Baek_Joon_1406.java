import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_Joon_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String word = br.readLine();
        int M = Integer.parseInt(br.readLine());
        
        Stack<String> headStack = new Stack<>();
        Stack<String> tailStack = new Stack<>();
        for(int i = 0; i < word.length(); i++) {
            headStack.push(word.charAt(i)+"");
        }

        
        
        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            String order = input[0];
            
            if(order.equals("L") && !headStack.isEmpty()) {
                tailStack.push(headStack.pop());
            } 
            else if(order.equals("D") && !tailStack.isEmpty()) {
                headStack.push(tailStack.pop());
            }
            else if(order.equals("B") && !headStack.isEmpty()) {
                headStack.pop();
            }
            else if(order.equals("P")){
                headStack.push(input[1]);
            } 

        }

        while(!headStack.isEmpty()) {
            tailStack.push(headStack.pop());
        }

        while(!tailStack.isEmpty()) {
            sb.append(tailStack.pop());
        }

        System.out.println(sb);

    }
}
