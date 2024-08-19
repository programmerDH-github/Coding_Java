import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] H_W = br.readLine().split(" ");
        int H = Integer.parseInt(H_W[0]);
        int W = Integer.parseInt(H_W[1]);

        int maxH = 0;        
        int[] map = new int[W];
        String[] block = br.readLine().split(" ");
        for(int i = 0; i < W; i++) {
            map[i] = Integer.parseInt(block[i]);
            if(map[i] > maxH) maxH = map[i];
        }

        System.out.println(maxH);

    }
}
