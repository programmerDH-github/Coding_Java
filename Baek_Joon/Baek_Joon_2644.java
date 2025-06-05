import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_2644 {
    static int[][] people;
    static boolean[][] visited;
    static int n,m,start,end;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        String[] start_end = br.readLine().split(" ");
        start = Integer.parseInt(start_end[0]);
        end = Integer.parseInt(start_end[1]);

        m = Integer.parseInt(br.readLine());
        people = new int[n+1][n+1];   
        visited = new boolean[n+1][n+1];
        for(int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            people[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 1;
            people[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = 1;
        }     

        bfs(start,0);

        System.out.println(answer == 0 ? -1 : answer);

    }

    static void bfs(int index, int count) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{index,count});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentIndex = current[0];
            int currentCount = current[1];

            if(currentIndex == end) {
                answer = currentCount;
                break;
            }

            for(int i = 1; i < n+1; i++) {
                if(people[currentIndex][i] == 1 && !visited[i][currentIndex]) {
                    visited[i][currentIndex] = true;
                    visited[currentIndex][i] = true;
                    queue.add(new int[]{i,currentCount+1});
                }
            }

        }
        
    }

}
