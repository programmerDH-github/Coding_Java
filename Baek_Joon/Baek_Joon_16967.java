import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_16967 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] H_W_X_Y = br.readLine().split(" ");
        int H = Integer.parseInt(H_W_X_Y[0]);
        int W = Integer.parseInt(H_W_X_Y[1]);
        int X = Integer.parseInt(H_W_X_Y[2]);
        int Y = Integer.parseInt(H_W_X_Y[3]);

        int[][] after = new int[H+X][W+Y];
        for(int i = 0; i < H+X; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < W+Y; j++) {
                after[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] before = new int[H][W];
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                if(i-X >= 0 && j-Y >= 0) before[i][j] = after[i][j] - before[i-X][j-Y];
                else before[i][j] = after[i][j];
            }
        }

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                sb.append(before[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
