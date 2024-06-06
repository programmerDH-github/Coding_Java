import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        boolean[][] check = new boolean[100][100];
        for(int i = 0; i < N; i++) {
            String[] x_y = br.readLine().split(" ");
            int x = Integer.parseInt(x_y[0]);
            int y = Integer.parseInt(x_y[1]);

            for(int j = x; j < x+10; j++) {
                for(int k = y; k < y+10; k++) {
                    check[j][k] = true;
                }
            }
        }

        int result = 0;
        for(int i = 0; i < check.length; i++) {
            for(int j = 0; j < check.length; j++) {
                if(check[i][j]) result++;
            }
        }

        System.out.println(result);

    }
}
