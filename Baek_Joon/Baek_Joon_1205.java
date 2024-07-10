import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Baek_Joon_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_score_P = br.readLine().split(" ");
        int N = Integer.parseInt(N_score_P[0]);
        int score = Integer.parseInt(N_score_P[1]);
        int P = Integer.parseInt(N_score_P[2]);

        if(N == 0) {
            System.out.println(1);
            return;
        }

        ArrayList<Integer> score_list = new ArrayList<>();
        String[] scores = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            score_list.add(Integer.parseInt(scores[i]));
        }
        
        score_list.add(score);
        Collections.sort(score_list, Collections.reverseOrder());

        if(N == P && score_list.get(N) >= score) {
            System.out.println(-1);
            return;
        }

        int[] rank = new int[score_list.size()];
        rank[0] = 1;
        for(int i = 0; i < score_list.size(); i++) {
            if(i == score_list.size()-1) {
                System.out.println(rank[i]);
                break;
            }
            if(score_list.get(i) == score_list.get(i+1)) {                
                rank[i+1] = rank[i];
            }
            else rank[i+1] = i+2;
            
            if(score_list.get(i) == score) {
                System.out.println(rank[i]);
                break;
            }
        }


    }
}
