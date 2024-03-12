import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            String[] N_M = br.readLine().split(" ");
            int N = Integer.parseInt(N_M[0]);
            int M = Integer.parseInt(N_M[1]);

            Queue<Integer> queue = new LinkedList<>();
            int target = 0;
            if(N == 1) {
                String doc = br.readLine();
                System.out.println(1);
                continue;
            }
            else {
                String[] doc = br.readLine().split(" ");
                for(int j = 0; j < doc.length; j++) {
                    queue.add(Integer.parseInt(doc[j]));
                    if(M == queue.size()-1) target = Integer.parseInt(doc[j]);
                }
            }

            int importance = 9;
            int print_count = 0;
            while(true) {
                if(target == importance) {
                    if(M == 0) {
                        print_count++;
                        break;
                    }
                    else if(queue.peek() == target) {
                        queue.poll();
                        print_count++;
                        M--;
                        if(M < 0) M = queue.size()-1;
                    }
                    else {
                        queue.add(queue.poll());
                        M--;
                        if(M < 0) M = queue.size()-1;
                    }
                }
                else {
                    if(queue.contains(importance)) {
                        if(queue.peek() == importance) {
                            queue.poll();
                            print_count++;
                            M--;
                            if(M < 0) M = queue.size()-1;
                        }
                        else {
                            queue.add(queue.poll());
                            M--;
                            if(M < 0) M = queue.size()-1;
                        }
                    }
                    else {
                        importance--;
                    }
                }
                
            }
            
            System.out.println(print_count);
        }
        
    }
}
