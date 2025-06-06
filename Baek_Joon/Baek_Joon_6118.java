import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_6118 {
    static int N,M,max;
    static int[] answer;
    static boolean[] visited;
    static ArrayList<Integer> arraylist[]; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        N = Integer.parseInt(N_M[0]);
        M = Integer.parseInt(N_M[1]);

        visited = new boolean[N];
        answer = new int[N];
        max = 0;        
        arraylist = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            arraylist[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            arraylist[Integer.parseInt(input[0])-1].add(Integer.parseInt(input[1])-1);
            arraylist[Integer.parseInt(input[1])-1].add(Integer.parseInt(input[0])-1);
        }

        bfs(0);

        int index = 0;
        int count = 0;
        for(int i = 0; i < N; i++) {
            if(answer[i] == max) {
                if(count == 0) index = i+1;
                count++;
            }
        }

        System.out.println(index+" "+max+" "+count);

    }

    static void bfs(int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));

        visited[start] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();          

            int currentIndex = node.index;
            int currentLength = node.length;

            answer[currentIndex] = currentLength;
            if(max < currentLength) max = currentLength;

            for(int idx : arraylist[currentIndex]) {
                if(!visited[idx]) {
                    visited[idx] = true;
                    queue.add(new Node(idx, currentLength+1));
                }
            } 

        }

    }

    static class Node {
        int index;
        int length;

        Node(int index, int length) {
            this.index = index;
            this.length = length;
        }

    }
    

}
