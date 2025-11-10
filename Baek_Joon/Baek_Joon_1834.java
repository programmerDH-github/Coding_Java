import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1834 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long answer = 0;

        long remainder = 1;
        while(N > remainder) {
            answer += N*remainder + remainder;
            remainder++;
        }

        System.out.println(answer);

    }
}
