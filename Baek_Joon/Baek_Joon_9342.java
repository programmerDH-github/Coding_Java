import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_9342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int order = 0;
        for(int i = 0; i < T; i++) {
            String input = br.readLine();

            if(input.length() < 3) {
                sb.append("Good").append("\n");
                continue;
            }

            for(int j = 0; j < input.length(); j++) {
                if(j == 0) {
                    if(input.charAt(j) != 'A' && input.charAt(j) != 'B' && input.charAt(j) != 'C' && input.charAt(j) != 'D' && input.charAt(j) != 'E' && input.charAt(j) != 'F') {
                        break;
                    }
                }
            }

        }

        System.out.println(sb);

    }
}
