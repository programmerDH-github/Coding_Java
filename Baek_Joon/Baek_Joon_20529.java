import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_20529 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            if(N > 32) {
                sb.append(0).append("\n");
                continue;
            }

            String[] MBTI = br.readLine().split(" ");
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < N; j++) {
                for(int k = j+1; k < N; k++) {
                    for(int l = k+1; l < N; l++) {
                        int distance = 0;
                        for(int z = 0; z < 4; z++) {
                            if(MBTI[j].charAt(z) != MBTI[k].charAt(z)) distance++;
                            if(MBTI[j].charAt(z) != MBTI[l].charAt(z)) distance++;
                            if(MBTI[k].charAt(z) != MBTI[l].charAt(z)) distance++;
                        }

                        min = Math.min(min, distance);
                        if(min == 0) break;

                    }
                }
            }

            if(min == Integer.MAX_VALUE) sb.append(0).append("\n");
            else sb.append(min).append("\n");

        }

        System.out.println(sb);

    }
}
