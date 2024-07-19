import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Baek_Joon_20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        HashMap<String,Integer> files = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String[] file = br.readLine().split("\\.");
            if(!files.containsKey(file[1])) files.put(file[1], 1);
            else files.put(file[1], files.get(file[1])+1);
        }

        ArrayList<String> keySet = new ArrayList<>(files.keySet());

        Collections.sort(keySet, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for(String key : keySet) {
            sb.append(key).append(" ").append(files.get(key)).append("\n");
        }

        System.out.println(sb);

    }
}