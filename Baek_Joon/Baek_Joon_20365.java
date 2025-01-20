import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_20365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        
        String input = br.readLine();
        int BCount = 0;
        int RCount = 0;
        
        char before = 'X';
        for(int i = 0; i < input.length(); i++) {
            if(before != input.charAt(i)) {
                if(input.charAt(i) == 'B') BCount++;
                else RCount++;
            }
            before = input.charAt(i);
        }
        
        System.out.println(Math.min(RCount, BCount)+1);

    }
}
