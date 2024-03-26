import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Baek_Joon_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        
        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String,Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++) {
                String[] clothes = br.readLine().split(" ");
                if(!map.containsKey(clothes[1])) {
                    map.put(clothes[1],1);
                }
                else {
                    map.put(clothes[1], map.get(clothes[1])+1);
                }
            }

            int count = 1;
            List<String> keyList = new ArrayList<>(map.keySet());
            
            for(String key : keyList) {
                count *= (map.get(key)+1);
            }

            System.out.println(count-1);
        }
        
    }
}
