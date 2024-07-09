import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Baek_Joon_25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_game = br.readLine().split(" ");
        int N = Integer.parseInt(N_game[0]);
        String game = N_game[1];

        Set<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        if(game.equals("Y")) {
            System.out.println(set.size());
        }
        else if(game.equals("F")) {
            System.out.println(set.size()/2);

        }
        else {
            System.out.println(set.size()/3);
        }

    }
}
