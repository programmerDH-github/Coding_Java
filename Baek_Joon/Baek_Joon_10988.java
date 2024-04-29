import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        String front_word = "";
        String back_word = "";
        for(int i = 0; i < word.length(); i++) {
            if(word.length()%2 == 0) {
                if(i < word.length()/2) {
                    front_word += word.charAt(i);
                }
                else {
                    back_word = word.charAt(i) + back_word;
                }
            }
            else {
                if(i < word.length()/2) {
                    front_word += word.charAt(i);
                }
                else if(i > word.length()/2) {
                    back_word = word.charAt(i) + back_word;
                }
            }
        }

        if(front_word.equals(back_word)) System.out.println(1);
        else System.out.println(0);
    }
}
