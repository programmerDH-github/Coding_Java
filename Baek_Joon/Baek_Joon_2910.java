import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Baek_Joon_2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_C = br.readLine().split(" ");
        int N = Integer.parseInt(N_C[0]);
        int C = Integer.parseInt(N_C[1]);
        
        String[] arr = br.readLine().split(" ");
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> number_idx = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            if(!number_idx.contains(Integer.parseInt(arr[i]))) number_idx.add(Integer.parseInt(arr[i]));

            if(map.containsKey(Integer.parseInt(arr[i]))) {
                map.put(Integer.parseInt(arr[i]), map.get(Integer.parseInt(arr[i]))+1);
            }
            else {
                map.put(Integer.parseInt(arr[i]),1);
            }
        }
    
        ArrayList<Integer> keySet = new ArrayList<>(map.keySet());

        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(map.get(o2) == map.get(o1)) return number_idx.indexOf(o1) - number_idx.indexOf(o2);
                
                return map.get(o2) - map.get(o1);
            }
        });

        for(int key : keySet) {
            String str = key+" ";
            sb.append(str.repeat(map.get(key)));
        }

        System.out.println(sb);

    }
}
