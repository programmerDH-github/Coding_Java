import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1780 {
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        count = new int[3];

        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }




        for(int c : count) System.out.println(c);
        
    }

    static void back(int n, int[][] arr, int first, int second, int target) {
        if(n == 1) {
            count[target+1] += 1;
            return;
        }

        int value = arr[first][second];
        for(int i = first; i < n; i++) {
            for(int j = second; j < n; j++) {
                if(value != arr[i][j]) {
                    back(n/3, arr, 0,0,value);
                }                
            }
        }

    }

}
