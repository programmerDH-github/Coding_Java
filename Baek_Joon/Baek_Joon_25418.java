import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_25418 {
    static int A,K;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] A_K = br.readLine().split(" ");
        A = Integer.parseInt(A_K[0]);
        K = Integer.parseInt(A_K[1]);

        dp = new int[K+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // dfs(A,0);
        bfs(A);

        System.out.println(dp[K]);

    }

    static void bfs(int num) {
        Queue<int[]> queue = new LinkedList<>();
        dp[num] = 0;
        queue.offer(new int[]{num,0});

        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int number = arr[0];
            int count = arr[1];

            if(number+1 <= K && dp[number+1] > count+1) {
                dp[number+1] = count+1;
                queue.offer(new int[]{number+1,count+1});
            }
            if(number*2 <= K && dp[number*2] > count+1) {
                dp[number*2] = count+1;
                queue.offer(new int[]{number*2,count+1});
            }

        }
        

    }



    static void dfs(int num, int count) {
        dp[num] = Math.min(dp[num], count);
        if(num >= K) {
            return;
        }

        for(int i = 0; i < 2; i++) {            
            if(i == 0) {
                if(num+1 <= K && dp[num+1] >= count+1) {
                    dfs(num+1, count+1);
                }
            }
            else {
                if(num * 2 <= K && dp[num * 2] >= count+1) {
                    dfs(num * 2, count+1);
                }
            }

        }

    }

}
