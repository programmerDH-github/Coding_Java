import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String word = br.readLine();
        
        while(word.length() > 10) {
            sb.append(word.substring(0, 10)).append("\n");
            word = word.substring(10,word.length());
        }        
        
        sb.append(word);
        System.out.println(sb);

    }
}
