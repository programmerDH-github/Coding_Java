import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1992 {
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(N,0,0);

    }
    
    static void dfs(int size, int x, int y) {
        if(size == 1) {
            System.out.print(map[x][y]);
            return;
        }

        int first = map[x][y];
        for(int i = x; i < size+x; i++) {
            for(int j = y; j < size+y; j++) {
                if(first != map[i][j]) {
                    System.out.print("(");    

                    dfs(size/2,x,y);
                    dfs(size/2,x,y+size/2);
                    dfs(size/2,x+size/2,y);
                    dfs(size/2,x+size/2,y+size/2);

                    System.out.print(")");

                    return;
                }
            }
        }

        System.out.print(first);

    }
}
