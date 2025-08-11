import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baek_Joon_1342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0 ; i < S.length(); i++) {
            map.put(S.charAt(i),map.getOrDefault(S.charAt(i), 0) + 1);
        }

        System.out.println(map);

    }
}
