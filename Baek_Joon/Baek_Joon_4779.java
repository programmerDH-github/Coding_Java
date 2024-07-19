import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_4779 {
    static StringBuilder sb;
    static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while((str = br.readLine()) != null) {
            int N = Integer.parseInt(str);
            sb = new StringBuilder();

            int len = (int)Math.pow(3, N);
            sb.append("-".repeat(len));
            
            dfs(0, len);

            System.out.println(sb);
        }

        
        
    }


    static void dfs(int start, int size) {
        if(size == 1) {
            return;
        }
        
        int newsize = size / 3;

        for(int i = start+newsize; i < start+newsize*2; i++) {
            sb.setCharAt(i, ' ');
        }
        
        dfs(start, newsize);
        dfs(start+newsize*2, newsize);
        
    }
}
