import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_3182 {
    static int max = 0;
    static int maxIdx = 0;
    static int[] senior;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        senior = new int[N+1];
        
        for(int i = 1; i <= N; i++) {
            senior[i] = Integer.parseInt(br.readLine());
        }

        // for(int i = 1; i <= N; i++) {
        //     visited[i] = true;
        //     dfs(1,senior[i],i);
        //     visited[i] = false;
        // }

        for(int i = 1; i <= N; i++) {
            visited = new boolean[N+1];

            int idx = i;
            int count = 0;
            while(!visited[idx]) {
                visited[idx] = true;
                idx = senior[idx];
                count++;
            }
            
            if(max < count) {
                max = count;
                maxIdx = i;
            }

        }

        System.out.println(maxIdx);

    }

    static void dfs(int count, int idx, int targetIdx) {
        if(max < count) {
            max = count;
            maxIdx = targetIdx;
        }

        if(!visited[idx]) {
            visited[idx] = true;
            dfs(count+1, senior[idx], targetIdx);
            visited[idx] = false;
        }

    }

}
