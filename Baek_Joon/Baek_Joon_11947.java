import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_11947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            String input = br.readLine();
            int N = Integer.parseInt(input);

            
            String digits = (1+"0".repeat(input.length()-1));
            long mid = 5 * Long.parseLong(digits);
            

            if(N >= mid) {
                String fn = "";
                String midStr = mid + "";
                for(int j = 0; j < midStr.length(); j++) {
                    fn += 9 - (midStr.charAt(j) - '0');
                }

                sb.append(mid*Long.parseLong(fn)).append("\n");

            }
            else {
                String fn = "";
                for(int j = 0; j < input.length(); j++) {
                    fn += 9 - (input.charAt(j) - '0');
                }

                sb.append(N*Long.parseLong(fn)).append("\n");
            
            }

        }
        
        System.out.println(sb);

    }
}
