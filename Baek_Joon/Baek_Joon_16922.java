import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_16922 {
    static int[] number = {1,5,10,50};
    static int N;
    static boolean[] check = new boolean[1001];
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(0,0,0);
        

        System.out.println(answer);

    }

    static void dfs(int count, int idx, int sum) {
        if(count == N) {
            if(!check[sum]) {
                answer++;
                check[sum] = true;
            }
            return;
        }

        for(int i = idx; i < number.length; i++) {
            dfs(count+1, i, sum+number[i]);
        }

    }
}
