import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1780 {
    static int[] count;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        count = new int[3];

        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        back(N,0, 0, arr[0][0]);

        for(int c : count) System.out.println(c);
        
    }

    static void back(int n, int x, int y, int target) {
        if(check(x, y, n, target)) {
            count[target+1] += 1;
            return;
        }
        
        n /= 3;

        back(n, x, y, arr[x][y]);
        back(n, x, y+n, arr[x][y+n]);
        back(n, x, y+2*n, arr[x][y+2*n]);

        back(n, x+n, y, arr[x+n][y]);
        back(n, x+n, y+n, arr[x+n][y+n]);
        back(n, x+n, y+2*n, arr[x+n][y+2*n]);

        back(n, x+2*n, y, arr[x+2*n][y]);
        back(n, x+2*n, y+n, arr[x+2*n][y+n]);
        back(n, x+2*n, y+2*n, arr[x+2*n][y+2*n]);

    }

    static boolean check(int x, int y, int n, int target) {
        for(int i = x; i < x+n; i++) {
            for(int j = y; j < y+n; j++) {
                if(target != arr[i][j]) return false;
            }
        }
        return true;
    }

}
