import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek_Joon_1343 {
    static String[] polyomino = {"AAAA","BB"};
    static StringBuilder sb;
    static ArrayList<String> arraylist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();        
        String board = br.readLine();
        
        arraylist = new ArrayList<>();
        String word = "";
        for(int i = 0; i < board.length(); i++) {
            if(board.charAt(i) == '.') {
                cover(word, "");

                if(arraylist.isEmpty()) {
                    System.out.println(-1);
                    return;
                }

                sb.append(arraylist.get(0)).append('.');
                arraylist.clear();
                word = "";
            }
            else if(board.charAt(i) == 'X') {
                word += 'X';
            }

            if(i == board.length()-1) {
                cover(word, "");
                if(arraylist.isEmpty()) {
                    System.out.println(-1);
                    return;
                }

                sb.append(arraylist.get(0));
            }

        }

        System.out.println(sb);

    }

    static void cover(String word, String input) {
        if(word.length() <= input.length()) {
            if(word.length() == input.length()) {
                arraylist.add(input);
            }

            return;
        }

        for(int i = 0; i < 2; i++) {
            cover(word, input+polyomino[i]);
        }


    }

}
