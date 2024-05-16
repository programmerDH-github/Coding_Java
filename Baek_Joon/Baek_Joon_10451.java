import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_10451 {
    static int start = 0, end = 0;
    static int cycle;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            visited = new boolean[N+1];
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            cycle = 0;

            for(int j = 0; j < arr.length; j++) {
                if(!visited[j+1]) {
                    start = j;
                    end = arr[j];
                    dfs(start,end);
                }
            }

            System.out.println(cycle);

        }

    }

    static void dfs(int x, int y) {
        visited[x+1] = true;

        if(start == y-1) {
            if(start == y-1) {
                cycle++;
            }
            return;
        }

        if(x == y-1) {
            cycle++;
            return;
        }

        dfs(y-1,arr[y-1]);     

    }
    
}
