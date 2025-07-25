import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_9081 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String str = br.readLine();
            char[] input = str.toCharArray();

            int leftIdx = -1;
            int rightIdx = 0;
            for(int j = input.length-1; j > 0; j--) {
                if(input[j] > input[j-1]) {
                    leftIdx = j-1;
                    break;
                }
            }

            if(leftIdx == -1) {
                sb.append(str).append("\n");
                continue;
            }

            for(int j = input.length-1; j >= 0; j--) {
                if(input[leftIdx] < input[j]) {
                    rightIdx = j;
                    break;
                }
            }

            char temp = input[leftIdx];
            input[leftIdx] = input[rightIdx];
            input[rightIdx] = temp;
            
            Arrays.sort(input,leftIdx+1,input.length);

            for(char c : input) sb.append(c);
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
