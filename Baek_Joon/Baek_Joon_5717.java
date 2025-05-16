import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_5717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String[] M_F = br.readLine().split(" ");
            int M = Integer.parseInt(M_F[0]);
            int F = Integer.parseInt(M_F[1]);

            if(M == 0 && F == 0) break;

            sb.append(M+F).append("\n");
            
        }

        System.out.println(sb);

    }
}