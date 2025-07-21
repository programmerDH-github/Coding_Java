import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_24460 {
    static long[][] participant;
    // static long[] answer = new long[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int M = Integer.parseInt(br.readLine());
        if(M <= 1) {
            System.out.println(br.readLine());
            return;
        }

        participant = new long[M][M];
        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                participant[i][j] = Long.parseLong(input[j]);
            }
        }

        System.out.println(dfs(0, 0, M));

    }

    static long dfs(int x, int y, int n) {
        if(n == 1) {
            return participant[x][y];
        }
        // if(n == 2) {
        //     answer[0] = participant[x][y];
        //     answer[1] = participant[x][y+1];
        //     answer[2] = participant[x+1][y];
        //     answer[3] = participant[x+1][y+1];

        //     Arrays.sort(answer);

        //     return answer[1];    
        // }

        n /= 2;
        long[] answer = new long[4];
        answer[0] = dfs(x,y,n);
        answer[1] = dfs(x,y+n,n);
        answer[2] = dfs(x+n, y, n);
        answer[3] = dfs(x+n, y+n, n);        

        Arrays.sort(answer);

        return answer[1];

    }

}
