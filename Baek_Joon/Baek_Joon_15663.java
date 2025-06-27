import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Baek_Joon_15663 {
    static int N,M;
    static int[] numbers;
    static boolean[] checked;
    static HashMap<String,Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        N = Integer.parseInt(N_M[0]);
        M = Integer.parseInt(N_M[1]);

        numbers = new int[N];
        checked = new boolean[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) numbers[i] = Integer.parseInt(input[i]);

        Arrays.sort(numbers);

        back(0, "");

        System.out.println(sb);

    }

    static void back(int count, String str) {
        if(count == M) {
            if(!map.containsKey(str)) {
                map.put(str, 0);
                sb.append(str).append("\n");
            }
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!checked[i]) {
                checked[i] = true;
                back(count+1, str+numbers[i]+" ");
                checked[i] = false;
            }
        }

    }

}
