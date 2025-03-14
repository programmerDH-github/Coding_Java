import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_12847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n_m = br.readLine().split(" ");
        int n = Integer.parseInt(n_m[0]);
        int m = Integer.parseInt(n_m[1]);

        int[] daily = new int[n];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            daily[i] = Integer.parseInt(input[i]);
        } 

        long salary = 0;
        for(int i = 0; i < m; i++) {
            salary += daily[i];
        }

        long max = salary;
        for(int i = m; i < n; i++) {
            salary -= daily[i-m];
            salary += daily[i];

            max = Math.max(max, salary);
        }

        System.out.println(max);

    }
}
