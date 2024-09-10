import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        
        int aLength = 0;
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == 'a') {
                aLength++;
            }
        }

        int min = Integer.MAX_VALUE;        
        for(int i = 0; i < word.length(); i++) {
            int bCount = 0;
            for(int j = i; j < i+aLength; j++) {
                if(word.charAt(j % word.length()) == 'b') bCount++;
            }

            if(min > bCount) min = bCount;
        }

        System.out.println(min);

    }
}
