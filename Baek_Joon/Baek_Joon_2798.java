import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        String[] input = br.readLine().split(" ");
        int[] card = new int[N];
        for(int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(card);

        int answer = 0;
        for(int i = 0; i < N; i++) {

            if(card[i] >= M) break;

            for(int j = i+1; j < N; j++) {

                if(card[i]+card[j] >= M) break;

                for(int k = j+1; k < N; k++) {

                    if(card[i]+card[j]+card[k] > M) break;
                    else if(answer < card[i]+card[j]+card[k]) answer = card[i]+card[j]+card[k];                    

                }
            }
        }

        System.out.println(answer);

    }
}
