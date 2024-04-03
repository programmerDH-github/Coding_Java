import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_17412 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String sentence = br.readLine();

        String word = "";
        for(int i = 0; i < sentence.length(); i++) {
            if(sentence.charAt(i) == '>') {
                word += ">";
                for(int j = 0; j < word.length(); j++) {
                    sb.append(word.charAt(j));
                }
                word = "";
            }
            else if(sentence.charAt(i) == ' ') {
                System.out.println("i : "+i);
                if(word.charAt(0) != '<') {
                    for(int j = 0; j < word.length(); j++) {
                        sb.append(word.charAt(word.length()-1-j));
                    }
                    sb.append(" ");
                    word = "";
                }
            }
            else {
                word += sentence.charAt(i);
            }

            if(word.length() != 0 && i == sentence.length()-1) {
                for(int j = 0; j < word.length(); j++) {
                    sb.append(word.charAt(word.length()-1-j));
                }
            }
        }

        System.out.println(sb);

    }
}
