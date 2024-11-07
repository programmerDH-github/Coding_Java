import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Baek_Joon_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n_k = br.readLine().split(" ");
        int n = Integer.parseInt(n_k[0]);
        int k = Integer.parseInt(n_k[1]);

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if(!map.containsKey(number)) map.put(number, number);
        }

        ArrayList<Integer> keySet = new ArrayList<>(map.keySet());

        Collections.sort(keySet);

        int[] coin = new int[keySet.size()];
        for(int i = 0; i < coin.length; i++) {
            coin[i] = keySet.get(i);
        }

        int[] dp = new int[k+1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;        

        for(int i = 0; i < coin.length; i++) {
            for(int j = coin[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j],dp[j-coin[i]]+1);
            }
        }

        if(dp[k] == 100001) System.out.println(-1);
        else System.out.println(dp[k]);

    }
}
