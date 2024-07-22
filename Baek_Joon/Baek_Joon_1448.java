import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Baek_Joon_1448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] straws = new Integer[N];

        for(int i = 0; i < N; i++) {
            straws[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(straws, Collections.reverseOrder());

        int answer = -1;
        for(int i = 0; i < N-2; i++) {
            if(straws[i] < straws[i+1]+straws[i+2]) {
                answer = straws[i] + straws[i+1] + straws[i+2];
                break;
            }
        }

        System.out.println(answer);

    }
}