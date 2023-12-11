import java.io.*;
import java.util.*;

public class Baek_Joon_10828 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            String[] order = br.readLine().split(" ");
            if(order[0].equals("push")) {
                stack.push(Integer.parseInt(order[1]));
            }
            else if(order[0].equals("pop")) {
                if(stack.empty()) System.out.println("-1");
                else System.out.println(stack.pop());
            }
            else if(order[0].equals("size")) {
                System.out.println(stack.size());
            }
            else if(order[0].equals("empty")) {
                if(stack.empty()) System.out.println("1");
                else System.out.println("0");
            }
            else {
                if(stack.empty()) System.out.println("-1");
                else System.out.println(stack.peek());
            }
        }
    }
}