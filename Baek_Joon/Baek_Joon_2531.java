import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baek_Joon_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_d_k_c = br.readLine().split(" ");

        int N = Integer.parseInt(N_d_k_c[0]);
        int d = Integer.parseInt(N_d_k_c[1]);
        int k = Integer.parseInt(N_d_k_c[2]);
        int c = Integer.parseInt(N_d_k_c[3]);

        int[] sushi = new int[N];
        for(int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int i = 0;
        int j = 0;
        int count = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(i < N) {
            if(count == k) {
                if(!map.containsKey(c)) max = Math.max(max,map.size()+1);
                else max = Math.max(max,map.size());

                map.remove(sushi[i]);
                count = 0;
                i++;
                j = i;
                continue;
            }            

            map.put(sushi[j%N], 1);
            count++;
            j++;


        }

        System.out.println(max);

    }
}
