import java.io.*;

public class Baek_Joon_2559 {
    static int N,K;
    static int[] temperatures;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_K = br.readLine().split(" ");
        N = Integer.parseInt(N_K[0]);
        K = Integer.parseInt(N_K[1]);

        temperatures = new int[N];
        String[] temperature = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            temperatures[i] = Integer.parseInt(temperature[i]);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            if(N-i < K) break;

            int sum = temperatures[i];
            for(int j = i+1; j < N; j++) {
                if(j-i == K) break;
                
                sum += temperatures[j];
            }
            if(max < sum) max = sum;
        }

        System.out.println(max);

    }
}
