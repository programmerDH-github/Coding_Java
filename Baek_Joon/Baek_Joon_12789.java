import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Baek_Joon_12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Queue<Integer> queue = new LinkedList<>();
        String[] student = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            queue.offer(Integer.parseInt(student[i]));
        }
        
        Stack<Integer> stack = new Stack<>();
        int number = 1;
        while(!stack.isEmpty() || !queue.isEmpty()) {
            if(queue.contains(number)) {
                if(queue.peek() == number) {
                    queue.poll();
                    number++;
                }
                else {
                    stack.add(queue.poll());
                }
            }
            else {
                if(stack.peek() == number) {
                    stack.pop();
                    number++;
                }
                else {
                    System.out.println("Sad");
                    return;
                }
            }
        }

        System.out.println("Nice");

    }
}
