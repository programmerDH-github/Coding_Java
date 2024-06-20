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

        int[] dp = {1,1,-1,-1};
        int[] dq = {1,-1,-1,1};
        int idx = 0;
        int np = p;
        int nq = q;
        while(t > 0) {
            t--;

            if(np == w) {
                if(nq == h) {
                    idx = 2;
                }
                else if(nq == 0) {
                    idx = 3;
                }
                else {
                    idx = 3;
                }
            }
            else if (np == 0) {
                if(nq == h) {
                    idx = 1;
                }
                else if(nq == 0) {
                    idx = 0;
                }
                else {
                    idx = 0;
                }
            }
            else {
                if(nq == h) {
                    if(idx == 3) idx  = 2;
                    else idx = 1;
                }
                else if(nq == 0) {
                    if(idx == 2) idx  = 3;
                    else idx = 0;
                }
                
            }

            np = dp[idx] + np;
            nq = dq[idx] + nq;

            
            
        }

        System.out.println(np+" "+nq);
        

    }
}
