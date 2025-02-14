import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_12018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n_m = br.readLine().split(" ");
        int n = Integer.parseInt(n_m[0]);
        int m = Integer.parseInt(n_m[1]);

        int[] min = new int[n];
        for(int i = 0; i < n; i++) {
            String[] P_L = br.readLine().split(" ");
            int P = Integer.parseInt(P_L[0]);
            int L = Integer.parseInt(P_L[1]);

            int[] people = new int[P];
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < P; j++) {
                people[j] = Integer.parseInt(input[j]);
            }

            Arrays.sort(people);
            if(P < L) min[i] = 1;
            else min[i] = people[P-L];

        }

        int answer = 0;
        Arrays.sort(min);
        for(int i = 0; i < n; i++) {
            if(min[i] <= m) {
                m -= min[i];
                answer++;
            }
        }

        System.out.println(answer);

    }
}
