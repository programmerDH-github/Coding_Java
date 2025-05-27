import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1614 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int injuryFinger = Integer.parseInt(br.readLine());
        long count = Long.parseLong(br.readLine());    

        if(count == 0) sb.append(injuryFinger-1);
        else {
            long answer = 0;
            if(injuryFinger == 1 || injuryFinger == 5)  {
                if(injuryFinger == 1) answer = 8*count;
                else answer = 8*count + 4;
            }
            else {
                if(count%2 == 0) answer = 8*(count/2) + (injuryFinger-1);
                else answer = 8*(count/2+1) - (injuryFinger-1);
            }
            sb.append(answer);
        }

        System.out.println(sb);

    }
}
