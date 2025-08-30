import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number = 1;
        while(true) {
            String[] L_P_V = br.readLine().split(" ");        
            int L = Integer.parseInt(L_P_V[0]);
            int P = Integer.parseInt(L_P_V[1]);
            int V = Integer.parseInt(L_P_V[2]);

            if(L == 0 && P == 0 && V == 0) break;

            int answer = (V / P) * L;

            if((V % P) >= L) answer += L;
            else answer += (V % P);
            
            sb.append("Case "+number+": "+answer).append("\n");            

            number++;
        }       

        System.out.println(sb);

    }
}
