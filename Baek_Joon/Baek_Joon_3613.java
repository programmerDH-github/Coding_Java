import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_3613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("_");

        if(input.length == 1) {

        }
        else {
            String answer = input[0];
            for(int i = 1; i < input.length; i++) {
                answer += input[i].substring(0,1).toUpperCase();
                answer += input[i].substring(1);
            }
            System.out.println(answer);
        }

        

    }
}
