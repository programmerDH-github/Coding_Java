import java.io.*;

public class Baek_Joon_11047 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_K = br.readLine().split(" ");
        int N = Integer.parseInt(N_K[0]);
        int K = Integer.parseInt(N_K[1]);

        int[] coin_cost = new int[N];
        for(int i = 0; i < N; i++) {
            coin_cost[i] = Integer.parseInt(br.readLine());
        }

        int coin_count = 0;
        for(int i = coin_cost.length-1; i >= 0; i--) {
            if(K < coin_cost[i]) continue;
            else {
                coin_count += K / coin_cost[i];
                K = K % coin_cost[i];
            }
        }

        System.out.println(coin_count);
        
    }
}
