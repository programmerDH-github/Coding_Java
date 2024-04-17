import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_Joon_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String order = br.readLine();
        
        int[] number = new int[N];
        for(int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }
        
        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < order.length(); i++) {
            if(order.charAt(i) == '+') {
                double number1 = stack.pop();
                double number2 = stack.pop();
                stack.push(number2 + number1);
            }
            else if(order.charAt(i) == '-') {
                double number1 = stack.pop();
                double number2 = stack.pop();
                stack.push(number2 - number1);
            }
            else if(order.charAt(i) == '*') {
                double number1 = stack.pop();
                double number2 = stack.pop();
                stack.push(number2 * number1);
            }
            else if(order.charAt(i) == '/') {
                double number1 = stack.pop();
                double number2 = stack.pop();
                stack.push((double)(number2 / number1));
            }
            else {
                stack.push((double)number[order.charAt(i) - 65]);
            }

        } 

        System.out.println(String.format("%.2f", stack.pop()));

    }
}
