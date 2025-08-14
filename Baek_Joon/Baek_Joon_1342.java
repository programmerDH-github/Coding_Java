import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1342 {
    static int[] alphabet = new int[27];
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        for(int i = 0; i < S.length(); i++) {
            alphabet[S.charAt(i) - 'a']++;
        }
        
        dfs(S,0,"");

        System.out.println(count);

    }

    static void dfs(String s, int index, String temp) {
        if(index == s.length()) {
            count++;
            return;
        }

        

        for(int i = 0; i < 27; i++) {
            if(alphabet[i] == 0) continue;

            if(temp.length() == 0 || temp.charAt(temp.length()-1) != (char)('a'+i)) {
                alphabet[i]--;
                dfs(s,index+1,temp+(char)('a'+i));
                alphabet[i]++;
            }
        }


    }

}
