import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Baek_Joon_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        // ArrayList<String> pokemon = new ArrayList<>();
        HashMap<Integer, String> pokemon_number = new HashMap<>();
        HashMap<String, Integer> pokemon_name = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            pokemon_number.put(i+1,input);
            pokemon_name.put(input,i+1);

        }
        
        for(int i = 0; i < M; i++) {
            String input = br.readLine();

            if(pokemon_name.containsKey(input)) {
                sb.append(pokemon_name.get(input));
            }            
            else if(pokemon_number.containsKey(Integer.parseInt(input))) {
                sb.append(pokemon_number.get(Integer.parseInt(input)));
            }

            sb.append("\n");
        }
        
        System.out.println(sb);

    }
}
