import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int M = Integer.parseInt(input[0]);
            int N = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2])-1;
            int y = Integer.parseInt(input[3])-1;

            int order = -1;
            for(int j = x; j < (M*N); j += M) {
                if(j % N == y) {
                    order = j + 1;
                    break;
                }
            }

            sb.append(order).append("\n");

        }

        System.out.println(sb);

    }
}
