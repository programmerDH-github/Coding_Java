import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            String[] input = br.readLine().split(" ");
            if(input[0].equals("0")) break;

            int[] number = new int[3];
            for(int j = 0; j < 3; j++) {
                number[j] = Integer.parseInt(input[j]);
            }

            Arrays.sort(number);

            if(number[0]*number[0]+number[1]*number[1] == number[2]*number[2]) sb.append("right");
            else sb.append("wrong");
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
