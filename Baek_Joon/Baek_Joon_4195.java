import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baek_Joon_4195 {
    static int[] parents;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int F = Integer.parseInt(br.readLine());
            HashMap<String,Integer> map = new HashMap<>();
            int idx = 0; 
            parents = new int[F*2];
            count = new int[F*2];

            for(int j = 0; j < F*2; j++) {
                parents[j] = j;
                count[j] = 1;
            }
            
            for(int j = 0; j < F; j++) {
                String[] friend = br.readLine().split(" ");
                if(!map.containsKey(friend[0])) {
                    map.put(friend[0], idx++);
                }
                
                if(!map.containsKey(friend[1])) {
                    map.put(friend[1], idx++);
                }

                sb.append(union(map.get(friend[0]), map.get(friend[1]))).append("\n");

            }
        }

        System.out.println(sb);

    }

    static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            if(x < y) {
                parents[y] = x;
                return count[x] += count[y];
            }
            else {
                parents[x] = y;
                return count[y] += count[x];
            }
        }

        return count[x];

    }

    static int find(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

}
