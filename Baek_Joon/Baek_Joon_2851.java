import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_2851 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] mushroom = new int[11];
        for(int i = 1; i <= 10; i++) {
            mushroom[i] = mushroom[i-1] + Integer.parseInt(br.readLine());
        }

        int close = Integer.MAX_VALUE;
        int answer = 0;
        for(int i = 1; i <= 10; i++) {
            if(Math.abs(100-mushroom[i]) == 0) {
                System.out.println(100);
                return;
            }

            if(close >= Math.abs(100-mushroom[i])) {
                close = Math.abs(100-mushroom[i]);
                answer = mushroom[i];
            }
        }

        System.out.println(answer);

    }
}
