import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_1759 {
    static int L,C;
    static String[] alphabet;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] L_C = br.readLine().split(" ");
        L = Integer.parseInt(L_C[0]);
        C = Integer.parseInt(L_C[1]);

        alphabet = br.readLine().split(" ");
        Arrays.sort(alphabet);

        dfs("",0,0,0);

        System.out.println(sb);

    }

    static void dfs(String str, int idx, int vowel, int consonant) {
        if(L == str.length()) {
            if(vowel >= 1 && consonant >= 2) {
                sb.append(str).append("\n");
            }            
            return;
        }

        for(int i = idx; i < C; i++) {
            if(alphabet[i].equals("a") || alphabet[i].equals("e") 
            || alphabet[i].equals("i") || alphabet[i].equals("o") 
            || alphabet[i].equals("u")) {
                dfs(str+alphabet[i], i+1, vowel+1, consonant);
            }
            else {
                dfs(str+alphabet[i], i+1, vowel, consonant+1);
            }
            
        }

    }

}
