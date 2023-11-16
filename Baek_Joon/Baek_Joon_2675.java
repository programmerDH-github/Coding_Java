import java.io.*;

/**
 * Baek_Joon_2675
 */
public class Baek_Joon_2675 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            String[] R_S = br.readLine().split(" ");
            String answer = "";

            for(int j = 0; j < R_S[1].length(); j++) {
                answer += (R_S[1].charAt(j)+"").repeat(Integer.parseInt(R_S[0]));
            }

            System.out.println(answer);
        }
    }
}