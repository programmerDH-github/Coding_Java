import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_5014 {
    static int[] floor = new int[1000001];
    static int F,S,G,U,D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] F_S_G_U_D = br.readLine().split(" ");
        F = Integer.parseInt(F_S_G_U_D[0]);
        S = Integer.parseInt(F_S_G_U_D[1]);
        G = Integer.parseInt(F_S_G_U_D[2]);
        U = Integer.parseInt(F_S_G_U_D[3]);
        D = Integer.parseInt(F_S_G_U_D[4]);

        if(S == G) System.out.println(0);
        else bfs();        

    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);

        floor[S] = 1;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            if(current == G) continue;
        
            for(int i = 0; i < 2; i++) {
                int next;
                if(i == 0) {
                    next = current + U;
                }
                else {
                    next = current - D;
                }
                
                

                if(next < 1 || next > F) continue;
                
                if(next == G) {
                    System.out.println(floor[current]);
                    return;
                }

                if(floor[next] == 0 || floor[next] > floor[current]+1) {
                    floor[next] = floor[current]+1;
                    queue.offer(next);
                }

            }
        }

        System.out.println("use the stairs");

    }
    
}