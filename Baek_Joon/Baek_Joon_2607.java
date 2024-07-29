import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String first = br.readLine();

        
        
        int answer = 0;
        for(int i = 0; i < N-1; i++) {
            int count = 0;

            int[] alphabet = new int[26];
            for(int j = 0; j < first.length(); j++) {
                alphabet[first.charAt(j)-65]++;
            }

            String second = br.readLine();
            for(int j = 0; j < second.length(); j++) {
                if(alphabet[second.charAt(j)-65] > 0) {
                    count++;
                    alphabet[second.charAt(j)-65]--;
                }
                
            }

            if(first.length() == second.length() && (first.length() == count || first.length()-1 == count)) answer++;
            else if(first.length() > second.length() && first.length()-1 == count) answer++;
            else if(first.length() < second.length() && second.length()-1 == count) answer++;            
        }

        System.out.println(answer);
        
    }
}