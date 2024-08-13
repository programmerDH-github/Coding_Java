import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baek_Joon_22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        HashMap<String,Integer> map= new HashMap<>();
        for(int i = 0; i < N; i++) {
            map.put(br.readLine(), 0);
        }

        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(",");

            for(int j = 0; j < input.length; j++) {
                if(map.containsKey(input[j])) map.remove(input[j]);
            }
            
            sb.append(map.size()).append("\n");
        }

        System.out.println(sb);


    }
}
