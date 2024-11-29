import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baek_Joon_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        HashMap<String,String> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            map.put(input[0], input[1]);
        }

        for(int i = 0; i < M; i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }

        System.out.println(sb);

    }
}
