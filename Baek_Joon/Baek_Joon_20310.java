import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] word = br.readLine().split("");
           
        int zeroCount = 0;
        int oneCount = 0;
        for(int i = 0; i < word.length; i++) {
            if(word[i].equals("0")) {
                zeroCount++;
            }
            else {
                oneCount++;
            }

        }
        
        oneCount /= 2;
        for(int i = 0; i < word.length; i++) {
            if(oneCount <= 0) break;

            if(word[i].equals("1")) {
                word[i] = "";
                oneCount--;
            }
        }

        zeroCount /= 2;
        for(int i = word.length-1; i >= 0; i--) {
            if(zeroCount <= 0) break;

            if(word[i].equals("0")) {
                word[i] = "";
                zeroCount--;
            }
        }

        for(int i = 0; i < word.length; i++) {
            if(word[i].equals("0") || word[i].equals("1")) {
                sb.append(word[i]);
            }
        }

        System.out.println(sb);

    }
}
