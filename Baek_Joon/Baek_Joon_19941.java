import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_K = br.readLine().split(" ");
        int N = Integer.parseInt(N_K[0]);
        int K = Integer.parseInt(N_K[1]);

        String[] str = br.readLine().split("");
        Boolean[] check = new Boolean[N];
        for(int i = 0; i < N; i++) {
            if(str[i].equals("P")) check[i] = true;
            else check[i] = false;
        }

        int count = 0;
        for(int i = 0; i < N; i++) {
            if(check[i] && str[i].equals("P")) {
                int start = i-K;
                int end = i+K;
                if(start < 0) start = 0;
                if(end >= N) end = N-1;

                for(int j = start; j <= end; j++) {
                    if(!check[j]) {
                        check[j] = true;
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);

    }
}
