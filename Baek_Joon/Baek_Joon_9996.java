import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] pattern = br.readLine().split("\\*");

        for(int i = 0; i < N; i++) {
            boolean check = false;
            String file = br.readLine();
            if(file.indexOf(pattern[0]) == 0) {
                for(int j = 0; j < pattern[1].length(); j++) {
                    if(pattern[1].charAt(j) == file.charAt(file.length()-pattern[1].length()+j)) {
                        check = true;
                    }
                    else {
                        check = false;
                        break;
                    }
                }
            }

            if(check) sb.append("DA").append("\n");
            else sb.append("NE").append("\n");
        }

        System.out.println(sb);

    }
}
