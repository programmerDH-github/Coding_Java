import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_2292 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int idx = 0;
        int last_value = 1;
        while(true) {
            if(last_value >= N) {
                System.out.println(idx+1);
                break;
            }
            idx++;
            last_value += 6*idx;	
        }

    }
}
