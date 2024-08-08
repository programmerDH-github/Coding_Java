import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Baek_Joon_3758 {

    static class Info implements Comparable<Info> {
        int id,score, count, time;

        public Info(int id, int score, int count, int time) {
            this.id = id;
            this.score = score;
            this.count = count;
            this.time = time;
        }


        @Override
            public int compareTo(Info i) {
                if(this.score == i.score) {
                    if(this.count == i.count) {
                        return this.time - i.time;
                    }
                    return this.count - i.count;
                }
                return i.score - this.score;
            }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String[] n_k_t_m = br.readLine().split(" ");
            int n = Integer.parseInt(n_k_t_m[0]);
            int k = Integer.parseInt(n_k_t_m[1]);
            int t = Integer.parseInt(n_k_t_m[2]);
            int m = Integer.parseInt(n_k_t_m[3]);

            int[][] logs = new int[m][3];

            for(int j = 0; j < m; j++) {
                String[] I_J_S = br.readLine().split(" ");
                int I = Integer.parseInt(I_J_S[0]);
                int J = Integer.parseInt(I_J_S[1]);
                int S = Integer.parseInt(I_J_S[2]);

                logs[j][0] = I;
                logs[j][1] = J;
                logs[j][2] = S;

            }

            int[][] saveScore = new int[n+1][k+1];
            int[] submit = new int[n+1];
            int[] time = new int[n+1];

            for(int j = 0; j < m; j++) {
                int nowId = logs[j][0];
                int nowNum = logs[j][1];
                int nowScore = logs[j][2];

                submit[nowId]++;
                time[nowId] = j;

                if(nowScore > saveScore[nowId][nowNum]) saveScore[nowId][nowNum] = nowScore;
            }

            ArrayList<Info> list = new ArrayList<>();
            for(int j = 1; j <= n; j++) {
                int sum = 0;
                for(int z = 1; z <= k; z++) {
                    sum += saveScore[j][z];
                }
                list.add(new Info(j, sum, submit[j], time[j]));
            }

            Collections.sort(list);

            for(int j = 0; j < n; j++) {
                if(list.get(j).id == t) {
                    sb.append((j+1)).append("\n");
                }
            }    
        }
        System.out.println(sb);

    }
}
