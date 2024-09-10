import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_d_k_c = br.readLine().split(" ");

        int N = Integer.parseInt(N_d_k_c[0]);
        int d = Integer.parseInt(N_d_k_c[1]);
        int k = Integer.parseInt(N_d_k_c[2]);
        int c = Integer.parseInt(N_d_k_c[3]);

        int[] sushi = new int[N];
        for(int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] eat = new int[d+1];

        int count = 0;
        for(int i = 0; i < k; i++) {
            if(eat[sushi[i]] == 0) {
                count++;
            }
            eat[sushi[i]]++;
        }

        int max = count;

        for(int i = 1; i < N; i++) {
            
            if(max <= count) {
                if(eat[c] == 0) {
                    max = count + 1;
                }
                else {
                    max = count;
                }
            }

            int end = (i+k-1)%N;

            eat[sushi[i-1]]--;
            if(eat[sushi[i-1]] == 0) {
                count--;
            }

            if(eat[sushi[end]] == 0) {
                count++;
            }
            eat[sushi[end]]++;
            

        }

        System.out.println(max);

    }
}
