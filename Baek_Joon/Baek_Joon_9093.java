import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < input.length; j++) {
                String word = "";
                for(int k = 0; k < input[j].length(); k++) {
                    word += input[j].charAt(input[j].length()-1 - k);
                }
                sb.append(word).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
