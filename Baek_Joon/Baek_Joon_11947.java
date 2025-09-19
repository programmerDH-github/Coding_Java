import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_11947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[] planet = new long[n];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) planet[i] = Long.parseLong(input[i]);

        long speed = Integer.MIN_VALUE;
        for(int i = n-1; i >= 0; i--) {
            if(planet[i] > speed) {
                speed = planet[i];
            }
            else {
                if(speed % planet[i] != 0) speed = ((speed / planet[i]) + 1) * planet[i];
            }

        } 

        System.out.println(speed);
        
    }
}
