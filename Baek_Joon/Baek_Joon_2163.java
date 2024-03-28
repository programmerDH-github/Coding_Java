import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_2163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        int[][] chocolate = new int[301][301];

        chocolate[1][1] = 0;

        for(int i = 1; i < 301; i++) {
            for(int j = 1; j < 301; j++) {
                if(i == 1) {
                    chocolate[i][j] = j-i;
                }
                else if(j == 1) {
                    chocolate[i][j] = i-j;
                }
                else {
                    chocolate[i][j] = chocolate[i][j-1] + i;
                }
            }
        }

        System.out.println(chocolate[N][M]);

    }
}
