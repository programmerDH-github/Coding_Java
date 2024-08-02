import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Baek_Joon_16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String group = br.readLine();    
            int member = Integer.parseInt(br.readLine());
            
            map.put(group, new ArrayList<>());

            for(int j = 0; j < member; j++) {
                String memberName = br.readLine();
                map.get(group).add(memberName);
            }

            Collections.sort(map.get(group));
        }

        for(int i = 0; i < M; i++) {
            String quiz = br.readLine();
            int number = Integer.parseInt(br.readLine());

            if(number == 0) {
                for(String name : map.get(quiz)) {
                    sb.append(name).append("\n");
                }
            }
            else {
                ArrayList<String> keySet = new ArrayList<>(map.keySet());
                for(String key : keySet) {
                    if(map.get(key).contains(quiz)) {
                        sb.append(key).append("\n");
                    }
                }
            }
        }

        System.out.println(sb);

    }
}
