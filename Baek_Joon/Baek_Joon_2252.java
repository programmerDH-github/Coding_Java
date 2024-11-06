import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Baek_Joon_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int front = Integer.parseInt(input[0]);
            int back = Integer.parseInt(input[1]);
            
            if(!map.containsKey(front)) map.put(front, 0);            
            else map.put(front, map.get(front)-1);

            if(!map.containsKey(back)) map.put(back, 0);            
            else map.put(back, map.get(back)+1);

        }

        ArrayList<Integer> keySet = new ArrayList<>(map.keySet());

        Collections.sort(keySet, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(map.get(o1) == map.get(o2)) return o2-o1;
                return map.get(o1) - map.get(o2);
            }
        });

        for(int key : keySet) {
            sb.append(key).append(" ");
        }
        System.out.println(map);
        System.out.println(sb);

    }
}
