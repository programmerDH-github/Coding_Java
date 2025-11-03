import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_2810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int count = 0;
        for(int i = 0; i < N; i++) {
            if(input.charAt(i) == 'L') {
                i++;
            }
            count++;
        }

        if(input.contains("L")) System.out.println(count+1);
        else System.out.println(count);
        
    }
}
