import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_1697 {
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_K = br.readLine().split(" ");
        int N = Integer.parseInt(N_K[0]);
        int K = Integer.parseInt(N_K[1]);

        if(N == K) {
            System.out.println(0);
            return;
        }
        
        arr = new int[100001];
        visited = new boolean[100001];
        bfs(N,K);

        System.out.println(arr[K]);
    }

    public static void bfs(int N, int K) {
        visited[N] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while(!queue.isEmpty()) {
            int num = queue.poll();

            if(num == K) {
                return;
            }

            if(num+1 <= 100000 && !visited[num+1]) {
                visited[num+1] = true;
                arr[num+1] = arr[num] + 1;
                queue.add(num+1);
            }
            if(num-1 >= 0 && !visited[num-1]) {
                visited[num-1] = true;
                arr[num-1] = arr[num] + 1;
                queue.add(num-1);
            }
            if(2*num <= 100000 && !visited[2*num]) {
                visited[2*num] = true;
                arr[2*num] = arr[num] + 1;
                queue.add(2*num);
            }
        }
        return;
    }
}
