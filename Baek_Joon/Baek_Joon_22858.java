import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_22858 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_K = br.readLine().split(" ");
        int N = Integer.parseInt(N_K[0]);
        int K = Integer.parseInt(N_K[1]);

        int[] S = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(input[i]);
        }

        int[] D = new int[N];
        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            D[i] = Integer.parseInt(input[i]);
        }

        boolean check = false;
        int[] temp = new int[N];
        for(int i = 0; i < K; i++) {
            if(!check) {
                for(int j = 0; j < N; j++) {
                    temp[D[j]-1] = S[j];
                }
                check = true;
            }
            else {
                for(int j = 0; j < N; j++) {
                    S[D[j]-1] = temp[j];
                }
                check = false;
            }
        }

        if(check) for(int P : temp) sb.append(P).append(" ");
        else for(int P : S) sb.append(P).append(" ");
        
        System.out.println(sb);

    }
}
