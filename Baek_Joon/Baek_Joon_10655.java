import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_10655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] point = new int[N][2];
        for(int i = 0; i < N; i++) {
            String[] x_y = br.readLine().split(" ");
            int x = Integer.parseInt(x_y[0]); 
            int y = Integer.parseInt(x_y[1]);
            
            point[i][0] = x;
            point[i][1] = y;

        }

        int max = 0;
        int sum = 0;
        for(int i = 1; i < N; i++) {
            sum += Math.abs(point[i-1][0]-point[i][0]) + Math.abs(point[i-1][1]-point[i][1]);

            if(i == N-1) break;

            int jump = Math.abs(point[i-1][0]-point[i+1][0]) + Math.abs(point[i-1][1]-point[i+1][1]);
            int move = Math.abs(point[i-1][0]-point[i][0]) + Math.abs(point[i-1][1]-point[i][1]) + Math.abs(point[i][0]-point[i+1][0]) + Math.abs(point[i][1]-point[i+1][1]);

            max = Math.max(max, move-jump);

        }
        
        System.out.println(sum - max);

    }   
}
