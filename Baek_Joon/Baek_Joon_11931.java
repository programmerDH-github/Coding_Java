import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Integer[] number = new Integer[N];
        for(int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(number, ((o1,o2) -> o2-o1));

        for(int i = 0; i < N; i++) {
            sb.append(number[i]).append("\n");
        }

        System.out.println(sb);

    }
}
