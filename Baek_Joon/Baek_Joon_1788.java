import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1788 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if(N == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }

        int[] F = new int[1000001];
        F[0] = 0;
        F[1] = 1;

        int temp = Math.abs(N);

        for(int i = 2; i <= temp; i++) {
            F[i] = (F[i-1] + F[i-2])%1000000000;
        }

        if(N > 0) {
            System.out.println(1);
        }
        else {
            if(temp % 2 == 0) System.out.println(-1);
            else System.out.println(1);
        }

        System.out.println(F[temp]);

    }
}
