import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] L_R = br.readLine().split(" ");
        String L = L_R[0];
        String R = L_R[1];

        int count = 0;
        for(int i = 0; i < L.length(); i++) {
            if(L.length() != R.length() || L.charAt(i) != R.charAt(i)) break;
            
            if(L.charAt(i) == '8') count++;
        }

        System.out.println(count);

    }
}
