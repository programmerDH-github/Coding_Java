import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_6591 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String[] input = br.readLine().split(" ");
            if(input[0].equals("0") && input[1].equals("0")) {
                System.out.println(sb);
                break;
            }

            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            
            long answer = 1;
            for(int i = 1; i <= x; i++) {
                answer *= i;
            }

            for(int i = 1; i <= y; i++) {
                answer /= i;
            }

            for(int i = 1; i <= x-y; i++) {
                answer /= i;
            }

            System.out.println(answer);

        }

    }
}
