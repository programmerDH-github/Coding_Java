import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Baek_Joon_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        HashMap<String,Integer> hashmap = new HashMap<>();
        for(int i = 0; i < N; i++) {
            hashmap.put(br.readLine(),0);
        }

        ArrayList<String> answerlist = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            String name = br.readLine();
            if(hashmap.containsKey(name)) {
                answerlist.add(name);
            }
        }

        Collections.sort(answerlist);
        sb.append(answerlist.size()).append("\n");
        for(int i = 0; i < answerlist.size(); i++) {
            sb.append(answerlist.get(i)).append("\n");
        }
        System.out.println(sb);

    }
}
