import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_17829 {
    static int[][] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        System.out.println(polling(0, 0, N));
        
    }

    static int polling(int x, int y, int n) {
        if(n == 1) return arr[x][y];

        if(n == 2) {
            int[] newArr = new int[4];

            int idx = 0;
            for(int i = x; i < x+n; i++) {
                for(int j = y; j < y+n; j++) {
                    newArr[idx] = arr[i][j];
                    idx++;
                }
            }

            Arrays.sort(newArr);

            return newArr[2];
        }
        else {
            int[] newArr = new int[4];

            n /= 2;

            newArr[0] = polling(x, y, n);
            newArr[1] = polling(x, y+n, n);
            newArr[2] = polling(x+n, y, n);
            newArr[3] = polling(x+n, y+n, n);

            Arrays.sort(newArr);
            return newArr[2];
        }



    }

}
