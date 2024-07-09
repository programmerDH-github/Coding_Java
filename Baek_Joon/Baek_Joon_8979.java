import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Baek_Joon_8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_K = br.readLine().split(" ");
        int N = Integer.parseInt(N_K[0]);
        int K = Integer.parseInt(N_K[1]);

        int[][] country = new int[N][5];
        for(int i = 0; i < N; i++) {
            String[] medal = br.readLine().split(" ");
            for(int j = 0; j < 4; j++) {
                country[i][j] = Integer.parseInt(medal[j]);
            }
        }

        Arrays.sort(country, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[1] == o1[1]) {
                    if(o2[2] == o1[2]) {
                        return o2[3] - o1[3];
                    }
                    return o2[2] - o1[2];
                }
                return o2[1] - o1[1];
            }
        });

        country[0][4] = 1;
        for(int i = 1; i < N; i++) {
            if(K == country[i-1][0]) {
                System.out.println(country[i-1][4]);
                break;
            }

            if(country[i][1] == country[i-1][1] && country[i][2] == country[i-1][2] && country[i][3] == country[i-1][3]) {
                country[i][4] = country[i-1][4];
            }
            else {
                country[i][4] = i+1;
            }

            if(K == country[i][0]) {
                System.out.println(country[i][4]);
                break;
            }
        }


    }
}
