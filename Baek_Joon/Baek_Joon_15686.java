import java.io.*;
import java.util.*;

public class Baek_Joon_15686 {
    static ArrayList<int[]> home = new ArrayList<>();
    static ArrayList<int[]> chicken_store = new ArrayList<>();
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);
        int[][] maps = new int[N][N];
        

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(input[j]);
                if(input[j].equals("1")) {
                    home.add(new int[]{i,j});
                }
                else if(input[j].equals("2")) {
                    chicken_store.add(new int[]{i,j});
                }
            }
        }

        visited = new boolean[chicken_store.size()];
        dfs(M,0,0);

        System.out.println(answer);
    }

    public static int distance(int x1, int y1, int x2, int y2) {
        return (int)(Math.abs(x1-x2)+Math.abs(y1-y2));
    }

    public static void dfs(int M, int start, int count) {
        if(count == M) {
            int sum = 0;
            for(int i = 0; i < home.size(); i++) {
                int value = Integer.MAX_VALUE;

                for(int j = 0; j < chicken_store.size(); j++) {
                    if(visited[j]) {
                        int row = distance(home.get(i)[0], home.get(i)[1], chicken_store.get(j)[0], chicken_store.get(j)[1]);
                        value = Math.min(row,value); 
                    }
                }
                sum += value;
            }
            answer = Math.min(answer, sum);
            return;
        }

        for(int i = start; i < chicken_store.size(); i++) {
            visited[i] = true;
            dfs(M, i+1, count+1);
            visited[i] = false;
        }
    }
}
