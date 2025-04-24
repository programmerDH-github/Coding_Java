import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Baek_Joon_14225 {
    static int N;
    static int[] S;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        S = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(input);

        for(int i = 0; i < N; i++) {
            dfs(S[i], i, 1);
        }
        System.out.println(set);
        int answer = 0;
        for(int i = 0; i < set.size(); i++) {
            if(!set.contains(i+1)) {
                answer = i+1;
                break;
            }
        }

        if(answer == 0) System.out.println(set.size()+1);
        else System.out.println(answer);
        

    }

    static void dfs(int number, int idx, int count) {
        set.add(number);
        if(count == N) {
            return;
        }
        

        for(int i = idx+1; i < N; i++) {
            dfs(number+S[i], i, count+1);
        }

    }

}
