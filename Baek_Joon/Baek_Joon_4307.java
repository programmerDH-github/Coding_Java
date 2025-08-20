import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_4307 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String[] l_n = br.readLine().split(" ");
            int l = Integer.parseInt(l_n[0]);
            int n = Integer.parseInt(l_n[1]);


            int[] ant = new int[n];
            for(int j = 0; j < n; j++) {
                ant[j] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(ant);

            int minTime = 0;
            int maxTime = 0;

            for(int j = 0; j < n; j++) {
                int minTmp = Math.min(ant[j], l-ant[j]);
                int maxTmp = Math.max(ant[j], l-ant[j]);

                minTime = Math.max(minTmp, minTime);
                maxTime = Math.max(maxTmp, maxTime);

            }

            sb.append(minTime+" "+maxTime).append("\n");

        }

        System.out.println(sb);

    }
}
