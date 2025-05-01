import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_6986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_K = br.readLine().split(" ");
        int N = Integer.parseInt(N_K[0]);
        int K = Integer.parseInt(N_K[1]);

        double[] score = new double[N];
        for(int i = 0; i < N; i++) {
            score[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(score);
        double first = 0;
        for(int i = K; i < N-K; i++) {
            first += score[i];
        }

        first = first/(N-K*2);
        sb.append(String.format("%.2f", first)).append("\n");        

        double second = 0;
        for(int i = 0; i < N; i++) {
            if(i < K) {
                second += score[K];
            }
            else if(i > N-K-1) {
                second += score[N-K-1];
            }
            else {
                second += score[i];
            }            
        }

        second = second/N;
        sb.append(String.format("%.2f", second));

        System.out.println(sb);

    }
}
