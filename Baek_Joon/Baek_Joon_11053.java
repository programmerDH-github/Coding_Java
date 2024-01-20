import java.io.*;

public class Baek_Joon_11053 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        String[] arr = br.readLine().split(" ");
        for(int i = 0; i < arr.length; i++) {
            A[i] = Integer.parseInt(arr[i]);
        }
        
        int[] dp = new int[N];
        dp[0] = 1;
        
        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(A[i] > A[j]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        
        System.out.println(max);
    }
}
