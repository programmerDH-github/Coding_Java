import java.io.*;

public class Baek_Joon_5525 {
    static int N,M,count;
    static String S;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();

        int[] dp = new int[M];
        for(int i = 2; i < M; i++) {
            String str = S.substring(i-2, i+1);
            if("IOI".equals(str)) {
                dp[i] = dp[i-2] + 1;
            } 

            if(dp[i] >= N) count++;
        }
        
        System.out.println(count);

    }
}
