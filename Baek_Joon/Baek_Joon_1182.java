import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1182 {
    static int N,S;
    static int count = 0;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_S = br.readLine().split(" ");
        N = Integer.parseInt(N_S[0]);
        S = Integer.parseInt(N_S[1]);

        numbers = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) numbers[i] = Integer.parseInt(input[i]);
        
        dfs(0,0);

        System.out.println(S == 0 ? count-1 : count);

    }

    static void dfs(int index, int sum) {
        if(N == index) {
            if(sum == S) {
                count++;
            }
            return;
        }

        dfs(index+1,sum+numbers[index]);
        dfs(index+1, sum);

    }

}
