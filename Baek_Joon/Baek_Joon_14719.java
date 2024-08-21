import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] H_W = br.readLine().split(" ");
        int H = Integer.parseInt(H_W[0]);
        int W = Integer.parseInt(H_W[1]);
     
        int[] map = new int[W];
        String[] block = br.readLine().split(" ");
        for(int i = 0; i < W; i++) {
            map[i] = Integer.parseInt(block[i]);
            
        }

        int answer = 0;
        for(int i = 1; i < W-1; i++) {
            int leftH = 0;
            int rightH = 0;

            for(int j = 0; j < i; j++) {
                leftH = Math.max(map[j], leftH);
            }

            for(int j = i+1; j < W; j++) {
                rightH = Math.max(map[j], rightH);
            }

            if(map[i] < leftH && map[i] < rightH) answer += Math.min(leftH, rightH) - map[i]; 


        }

        System.out.println(answer);

    }
}
