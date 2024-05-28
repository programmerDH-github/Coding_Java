import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_Joon_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            if(word.length() < M) continue;
            if(!map.containsKey(word)) {
                map.put(word, 1);
            }
            else {
                map.put(word, map.get(word)+1);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1) != map.get(o2)) return map.get(o2).compareTo(map.get(o1));
                if(o1.length() != o2.length()) return o2.length() - o1.length();                
                return o1.compareTo(o2);
                
            }
        });
        
        for(String key : list) sb.append(key +"\n");
        System.out.println(sb);

    }
}
