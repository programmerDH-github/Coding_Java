import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baek_Joon_13023 {
    static int N,M;
    static List<Integer>[] list;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        N = Integer.parseInt(N_M[0]);
        M = Integer.parseInt(N_M[1]);

        list = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            list[x].add(y);
            list[y].add(x);

        }

        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            visited[i] = true;
            if(answer == 0) {
                dfs(i,1);
            }
            visited[i] = false;
        }

        System.out.println(answer);

    }

    static void dfs(int x, int count) {
        if(count == 5) {
            answer = 1;
            return;
        }

        // for(int i = 0; i < list[x].size(); i++) {
        //     if(!visited[list[x].get(i)]) {
        //         visited[list[x].get(i)] = true;
        //         dfs(i,count+1);
        //         visited[list[x].get(i)] = false;
        //     }
        // }

        for(int i : list[x]) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, count+1);
                visited[i] = false;
            }
        }


    }

}
