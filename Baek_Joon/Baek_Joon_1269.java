import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baek_Joon_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] A_B = br.readLine().split(" ");
        int A = Integer.parseInt(A_B[0]);
        int B = Integer.parseInt(A_B[1]);

        HashMap<Integer,Integer> map = new HashMap<>();

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < A; i++) {
            map.put(Integer.parseInt(input[i]), 1);
        }

        input = br.readLine().split(" ");
        for(int i = 0; i < B; i++) {
            if(map.containsKey(Integer.parseInt(input[i]))) map.remove(Integer.parseInt(input[i]));
            else map.put(Integer.parseInt(input[i]), 1);
        }

        System.out.println(map.size());
        
    }
}
