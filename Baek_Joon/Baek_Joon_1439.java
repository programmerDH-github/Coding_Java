import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int one_count = 0;
        int zero_count = 0;
        char current = S.charAt(0);
        for(int i = 0; i < S.length(); i++) {
            if(i == 0) {
                if(current == '0') zero_count++;
                else one_count++;

                continue;
            }
            
            if(current != S.charAt(i)) {
                current = S.charAt(i);

                if(current == '0') zero_count++;
                else one_count++;
            }            
        }

        System.out.println(Math.min(one_count, zero_count));

    }
}
