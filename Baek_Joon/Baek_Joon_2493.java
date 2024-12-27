import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_Joon_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Stack<int[]> antenna = new Stack<>();
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            while(!antenna.isEmpty()) {
                if(antenna.peek()[1] >= Integer.parseInt(input[i])) {
                    sb.append(antenna.peek()[0]+1).append(" ");
                    break;
                }

                antenna.pop();               

            }
            if(antenna.isEmpty()) {
                sb.append(0).append(" ");
            }

            antenna.push(new int[]{i,Integer.parseInt(input[i])});

        }

        System.out.println(sb);

    }
}
