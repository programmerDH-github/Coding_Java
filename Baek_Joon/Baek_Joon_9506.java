import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            int n = Integer.parseInt(br.readLine());

            if(n == -1) break;

            int perfect_num = 0;
            String element = "";
            for(int i = 1; i < n; i++) {
                if(n % i == 0) {
                    perfect_num += i;
                    element += i +" ";
                }
                if(perfect_num > n) break;                
            }

            if(perfect_num == n) {
                sb.append(n +" = ");
                String[] str = element.split(" ");

                for(int i = 0; i < str.length; i++) {
                    if(i == str.length-1) sb.append(str[i]).append("\n");
                    else sb.append(str[i]).append(" + ");
                }
                
            }
            else {
                sb.append(n + " is NOT perfect.\n");
            }
        }

        System.out.println(sb);

    }
}
