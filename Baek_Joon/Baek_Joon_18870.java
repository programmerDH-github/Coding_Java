import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Baek_Joon_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Map<Integer,Integer> map = new HashMap<>();
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            map.put(Integer.parseInt(input[i]), map.getOrDefault(input[i], 0)+1);
        }

        ArrayList<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        for(int i = 0; i < keySet.size(); i++) {
            map.replace(keySet.get(i), i);
        }

        Collections.sort(keySet);
        
        System.out.println();
        for(int i = 0; i < N; i++) {
            sb.append(map.get(Integer.parseInt(input[i]))).append(" ");
        }

        System.out.println(sb);

    }
}
