import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baek_Joon_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        HashMap<String,Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        String[] cards = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            if(!map.containsKey(cards[i])) map.put(cards[i], 1);
            else map.put(cards[i], map.get(cards[i])+1);
        }

        int M = Integer.parseInt(br.readLine());
        String[] number = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            if(!map.containsKey(number[i])) {
                sb.append(0).append(" ");
            }
            else {
                sb.append(map.get(number[i])).append(" ");
            }
        }

        System.out.println(sb);

    }
}
