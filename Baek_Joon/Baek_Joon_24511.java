import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Baek_Joon_24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        int[] A = new int[N];
        String[] Aarr = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(Aarr[i]);
        }

        Deque<Integer> deque = new LinkedList<>();

        String[] Barr = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            if(A[i] == 0) deque.offer(Integer.parseInt(Barr[i]));
        }
        
        int M = Integer.parseInt(br.readLine());
        int[] elements = new int[M];
        String[] elementArr = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            elements[i] = Integer.parseInt(elementArr[i]);
        }

        for(int i = 0; i < M; i++) {
            deque.offerFirst(elements[i]);
            sb.append(deque.pollLast()).append(" ");
        }

        System.out.println(sb);

    }
}