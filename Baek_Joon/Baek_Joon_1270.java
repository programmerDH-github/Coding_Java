import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Baek_Joon_1270 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int land = Integer.parseInt(input[0]);

            if(land == 0) {
                sb.append("SYJKGW").append("\n");
                continue;
            }
            if(land == 1) {
                sb.append(input[1]).append("\n");
                continue;
            }

            HashMap<Long,Integer> map = new HashMap<>();         
            for(int j = 0; j < land; j++) {
                Long number = Long.parseLong(input[j+1]);
                if(!map.containsKey(number)) map.put(number,1);
                else map.put(number, map.get(number)+1);
            }

            ArrayList<Long> keySet = new ArrayList<>(map.keySet());
            Collections.sort(keySet, (o1,o2) -> map.get(o2) - map.get(o1));
            
            if(map.get(keySet.get(0)) > land/2) sb.append(keySet.get(0)).append("\n");
            else sb.append("SYJKGW").append("\n");            

        }

        System.out.println(sb);

    }
}
