import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] A_B = br.readLine().split(" ");
        int A = Integer.parseInt(A_B[0]);
        int B = Integer.parseInt(A_B[1]);

        int[] numbers = new int[1001];
        
        int i = 1;
        int j = 1;
        while(true) {
            if(i > 1000) break;

            for(int k = 0; k < j; k++) {
                if(i > 1000) break;
                numbers[i] = j;
                i++;             
            }
            j++;
        }
        
        int answer = 0;
        for(i = A; i <= B; i++) {
            answer += numbers[i];
        }

        System.out.println(answer);


    }
}
