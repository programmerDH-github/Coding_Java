import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_10448 {
    static int[] triangle;
    static boolean checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        triangle = new int[1001]; 
        for(int i = 1; i < 1001; i++) {
            triangle[i] = triangle[i-1]+i;
        }

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int end = 0;
            for(int j = 1; j < 1001; j++) {
                if(N < triangle[j]) break;
                end = j;
                if(N == triangle[j]) break;
            }

            checked = false;
            dfs(0, end, 0, N);
            if(checked) sb.append(1);
            else sb.append(0);
            sb.append("\n");
            
        }

        System.out.println(sb);

    }

    static void dfs(int count, int end, int sum, int target) {
        if(checked) return;

        if(count == 3) {
            if(sum == target) checked = true;            
            return;
        }

        for(int i = 1; i <= end; i++) {
            dfs(count+1, end, sum+triangle[i], target);
        }
    

    }

}
