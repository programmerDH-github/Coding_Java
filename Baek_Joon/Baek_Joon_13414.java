import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Baek_Joon_13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] K_L = br.readLine().split(" ");
        int K = Integer.parseInt(K_L[0]);
        int L = Integer.parseInt(K_L[1]);

        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < L; i++) {
            String student = br.readLine();
            
            if(!map.containsKey(student)) map.put(student,i);
            else {
                map.put(student, i);
            }
        }  
        ArrayList<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });

        int count = 0;
        for(String key : keySet) {
            if(count == K) break;
            sb.append(key).append("\n");
            count++;
        }

        System.out.println(sb);

    }
}
