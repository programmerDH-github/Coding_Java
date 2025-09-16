import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_2594 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            time[i][0] = Integer.parseInt(input[0])/100*60 + Integer.parseInt(input[0])%100 - 10;
            time[i][1] = Integer.parseInt(input[1])/100*60 + Integer.parseInt(input[1])%100 + 10;  
        }

        Arrays.sort(time, (o1,o2) -> o1[0]-o2[0]);
        
        int max = Math.max(0, time[0][0]-10*60);
        int endMax = 0;
        for(int i = 1; i < N; i++) {
            endMax = Math.max(endMax, time[i-1][1]);
            if(time[i][0] > endMax) max = Math.max(max, time[i][0]-time[i-1][1]);
        }
        
        Arrays.sort(time, (o1,o2) -> o2[1]-o1[1]);
        max = Math.max(max, (22*60-time[0][1]));        

        System.out.println(max);

    }
}
