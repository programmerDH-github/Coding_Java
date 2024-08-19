import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baek_Joon_1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            map.put(i+1, Integer.parseInt(input[i]));
        }

        System.out.println(map);

    }
}
