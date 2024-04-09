import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long sum = 0;
        long count = 1;

        while(true) {
            if(sum >= S) break;
            sum += count;
            count++;
        }

        if(sum > S) System.out.println(count - 2);
        else System.out.println(count - 1);
    }
}
