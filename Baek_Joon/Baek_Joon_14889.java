import java.io.*;

public class Baek_Joon_14889 {
    static int N;
    static boolean[] check;
    static int[][] ability;
    static int min = 200;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ability = new int[N][N];
        check = new boolean[N];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                ability[i][j] = Integer.parseInt(input[j]);
            }
        }

        
        for(int i = 0; i < N; i++) {
            check[i] = true;
            dfs(1,i);
            check[i] = false;
        }

        System.out.println(min);

    }

    public static void dfs(int depth, int index) {
        if(depth == N/2) {
            int team_start = 0;
            int team_link = 0;
            for(int i = 0; i < N; i++) {
                if(check[i]) {
                    for(int j = i+1; j < N; j++) {
                        if(check[j]) team_start += ability[i][j] + ability[j][i];
                    }
                }
                else {
                    for(int j = i+1; j < N; j++) {
                        if(!check[j]) team_link += ability[i][j] + ability[j][i];
                    }
                }
            }
            if(min > Math.abs(team_start-team_link)) min = Math.abs(team_start-team_link);
            return;
        }

        for(int i = index; i < N; i++) {
            if(!check[i]) {
                check[i] = true;
                dfs(depth+1,i+1);
                check[i] = false;
            }
        }
    }
}
