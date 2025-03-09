import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_Joon_9252 {
    static String str1,str2;
    static int[][] dp;
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        str1 = br.readLine();
        str2 = br.readLine();

        dp = new int[str1.length()+1][str2.length()+1];
        for(int i = 1; i <= str1.length(); i++) {
            for(int j = 1; j <= str2.length(); j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        sb.append(dp[str1.length()][str2.length()]).append("\n");

        searchSubString(str1.length(), str2.length());

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);

    }

    static void searchSubString(int x, int y) {
        while(x > 0 && y > 0) {
            if(x == 0 || y == 0) break;
            if(dp[x][y] == dp[x-1][y-1]) {
                x--;
                y--;
            }
            else if(dp[x][y] == dp[x-1][y]) {
                x--;
            }
            else if(dp[x][y] == dp[x][y-1]) {
                y--;
            }
            else {
                stack.push(str1.charAt(x-1));
                x--;
                y--;
            }
        }
    }

}
