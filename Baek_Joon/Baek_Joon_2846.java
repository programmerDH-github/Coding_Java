import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_2846 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String[] input = br.readLine().split(" ");
        int[] load = new int[N];
        for(int i = 0; i < N; i++) {
            load[i] = Integer.parseInt(input[i]);
        }

        int max = 0;
        int pre = load[0];
        int result = 0;
        for(int i = 1; i < N; i++) {

            if(pre < load[i]) {
                result += load[i]-pre; 
            }
            else {
                max = Math.max(max,result);
                result = 0;
            }             

            pre = load[i];      

        }

        max = Math.max(max,result);
        System.out.println(max);

    }
}
