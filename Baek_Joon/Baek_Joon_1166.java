import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_L_W_H = br.readLine().split(" ");
        int N = Integer.parseInt(N_L_W_H[0]);
        int L = Integer.parseInt(N_L_W_H[1]);
        int W = Integer.parseInt(N_L_W_H[2]);
        int H = Integer.parseInt(N_L_W_H[3]);

        double left = 0;
        double right = Math.max(L, Math.max(W, H));
        while(left < right) {
            double mid = (left+right)/2;

            if(left == mid || right == mid) break;

            if((long)(L/mid) * (long)(W/mid) * (long)(H/mid) < N) {
                right = mid;
            }
            else {
                left = mid;
            }

        }

        System.out.println(left);

    }
}
