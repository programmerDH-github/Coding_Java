import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_3568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");

        for(int i = 1; i < input.length; i++) {
            sb.append(input[0]);
            String str = "";
            for(int j = input[i].length()-1; j >= 0; j--) {
                if(input[i].charAt(j) == ';' || input[i].charAt(j) == ',') continue;
                if(((int)input[i].charAt(j) >= 65 && (int)input[i].charAt(j) <= 90) || ((int)input[i].charAt(j) >= 97 && (int)input[i].charAt(j) <= 122)) {
                    str = input[i].charAt(j)+str;
                }
                else {
                    if(input[i].charAt(j) == '[') sb.append("]");
                    else if(input[i].charAt(j) == ']') sb.append("[");
                    else sb.append(input[i].charAt(j));
                }
            } 

            sb.append(" ").append(str).append(";").append("\n");

        }

        System.out.println(sb);

    }
}
