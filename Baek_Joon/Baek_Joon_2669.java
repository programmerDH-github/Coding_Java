import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[101][101];
        for(int i = 0; i < 4; i++) {
            String[] input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);

            for(int j = x1; j < x2; j++) {
                for(int z = y1; z < y2; z++) {
                    arr[j][z] = 1;
                }
            }
        }

        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }

        System.out.println(sum);

    }
}
