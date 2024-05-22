import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] game = new int[1000];

        for(int i = 0; i < N; i++) {
            String[] baseball = br.readLine().split(" ");
            int strike = Integer.parseInt(baseball[1]);
            int ball = Integer.parseInt(baseball[2]);

            for(int j = 123; j <= 987; j++) {
                String number = j+"";
                int s = 0;
                int b = 0;

                if(number.charAt(0) == '0' || number.charAt(1) == '0' || number.charAt(2) == '0' 
                || number.charAt(0) == number.charAt(1) || number.charAt(0) == number.charAt(2) 
                || number.charAt(1) == number.charAt(2)) continue;

                if(number.charAt(0) == baseball[0].charAt(0)) s++;
                else if(number.charAt(0) == baseball[0].charAt(1) || number.charAt(0) == baseball[0].charAt(2)) b++;

                if(number.charAt(1) == baseball[0].charAt(1)) s++;
                else if(number.charAt(1) == baseball[0].charAt(0) || number.charAt(1) == baseball[0].charAt(2)) b++;

                if(number.charAt(2) == baseball[0].charAt(2)) s++;
                else if(number.charAt(2) == baseball[0].charAt(0) || number.charAt(2) == baseball[0].charAt(1)) b++;

                if(strike == s && ball == b) {
                    game[j]++;
                }
            }

        }

        int answer = 0;
        for(int i = 123; i <= 987; i++) {
            if(game[i] == N) {
                answer++;
            }
        }

        System.out.println(answer);

    }
}
