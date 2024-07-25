import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();

        int min = 0;
        int idx = 0;
            
        while(idx < number.length()) {
            min++;

            String str = min + "";
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == number.charAt(idx)) {
                    idx++;
                }
                
                if(idx == number.length()) {
                    System.out.println(min);
                    return;
                }
            }
        }
    }
}
