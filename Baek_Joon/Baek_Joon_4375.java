import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        int n;
        long one,count;
        while((input = br.readLine()) != null) {
            n = Integer.parseInt(input);
            one = 1; count = 1;
            while(true) {
                if(one % n == 0) {
                    sb.append(count + "\n");
                    break;
                }
                else {
                    one = (one*10) + 1;
                    one %= n;
                    count++;
                }
            }            
        }
        System.out.println(sb);
    }
}
