import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_16194 {
    static int N,min;
    static int[] card;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        card = new int[N+1];
        String[] input = br.readLine().split(" ");
        for(int i = 1; i <= N; i++) card[i] = Integer.parseInt(input[i-1]);

        min = Integer.MAX_VALUE;
        dfs(0,0);

        System.out.println(min);

    }

    static void dfs(int count, int cost) {
        if(N < count) return;
        if(N == count) {
            if(min > cost) min = cost;
            return;
        }

        for(int i = 1; i <= N; i++) {
            dfs(count+i, cost+card[i]);
        }

    }

}
