import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] w_h = br.readLine().split(" ");
        int w = Integer.parseInt(w_h[0]);
        int h = Integer.parseInt(w_h[1]);

        String[] p_q = br.readLine().split(" ");
        int p = Integer.parseInt(p_q[0]);
        int q = Integer.parseInt(p_q[1]);

        int t = Integer.parseInt(br.readLine());
        
        int x = w - Math.abs(w - (p + t) % (w * 2));
        int y = h - Math.abs(h - (q + t) % (h * 2));

        System.out.println(x+" "+y);

    }
}
