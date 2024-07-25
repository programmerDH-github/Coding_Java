import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_2312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int idx = 2;
            int[] number = new int[N+1];
            while(N > 1) {
                if(N % idx == 0) {
                    number[idx]++;
                    N /= idx;
                    idx = 2;
                }
                else idx++;
            }

            for(int j = 1; j < number.length; j++) {
                if(number[j] != 0) {
                    sb.append(j).append(" ").append(number[j]).append("\n");
                }
            }

        }

        System.out.println(sb);

    }
    
}