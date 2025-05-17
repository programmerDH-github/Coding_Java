import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1527 {
    static int A,B;
    static String[] numbers = {"4","7"};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] A_B = br.readLine().split(" ");
    

        for(int i = 0; i < 2; i++) {
            check(A_B[0],A_B[1],numbers[i]);

        }
        
        System.out.println(answer);

    }

    static void check(String first, String second, String num) {
        if(Long.parseLong(num) > Long.parseLong(second)) {
            return;
        }

        if(first.length() <= num.length() && Integer.parseInt(first) <= Integer.parseInt(num) && Integer.parseInt(second) >= Integer.parseInt(num)) {
            answer++;
        }

        for(int i = 0; i < 2; i++) {
            check(first, second, num+numbers[i]);
        }

    }

}
