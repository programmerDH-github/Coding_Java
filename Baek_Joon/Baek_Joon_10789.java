import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_10789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[][] words = new String[5][];

        for(int i = 0; i < words.length; i++) {
            words[i] = br.readLine().split("");
        }

        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 5; j++) {
                if(i >= words[j].length) continue;
                sb.append(words[j][i]);
            }
        }

        System.out.println(sb);

    }
}
