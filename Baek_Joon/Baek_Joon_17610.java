import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_17610 {
    static int k;
    static int[] weight;
    static boolean[] checked;
    static boolean[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        weight = new int[k];
        checked = new boolean[k];
        String[] input = br.readLine().split(" ");
        int S = 0;
        for(int i = 0; i < k; i++) {
            weight[i] = Integer.parseInt(input[i]);
            S += weight[i];
        }
        answer = new boolean[S+1];

        for(int i = 0; i < k; i++) {
            checked[i] = true;
            dfs(weight[i], i);
            checked[i] = false;
        }

        int count = 0;
        for(int i = 1; i <= S; i++) {
            if(!answer[i]) {
                count++;
            }
        }

        System.out.println(count);

    }

    static void dfs(int sum, int idx) {
        answer[sum] = true;

        for(int i = idx+1; i < k; i++) {
            for(int j = 0; j < 2; j++) {
                if(!checked[i]) {
                    if(j == 0) {
                        checked[i] = true;
                        dfs(sum+weight[i],i);
                        checked[i] = false;
                    }
                    else {                                                   
                        checked[i] = true;
                        dfs(Math.abs(sum-weight[i]),i);
                        checked[i] = false;
                    }
                    
                }
            }
            
        }


    }

}
