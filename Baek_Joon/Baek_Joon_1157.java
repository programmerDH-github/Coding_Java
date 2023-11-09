import java.util.*;
import java.io.*;

public class Baek_Joon_1157 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        word = word.toUpperCase();
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < word.length(); i++) {
            String alphbet = word.charAt(i) + "";
            if(map.containsKey(alphbet)) {
                map.put(alphbet, map.get(alphbet)+1);
            }
            else {
                map.put(alphbet, 1);
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());

        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        int count = 0;
        String answer = "";
        for(String key : keySet) {
            System.out.print("Key : " + key);
            System.out.println(", Val : " + map.get(key));
            if(count == 0) {
                count = map.get(key);
                answer = key;
            }
            else {
                if(count == map.get(key)) {
                    System.out.println("?");
                    return;
                }
            }
        }

        System.out.println(answer);
    }
}