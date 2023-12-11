import java.io.*;
import java.util.*;

public class Baek_Joon_1316 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int count = 0;
        
        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            char alphabet = word.charAt(0);
            ArrayList<Character> arraylist = new ArrayList<>();

            if(word.length() == 1 || word.length() == 2) {
                count++;
                continue;
            }

            for(int j = 1; j < word.length(); j++) {
                if(alphabet == word.charAt(j)) {
                    if(j == word.length()-1) count++;
                    continue;
                }
                else {
                    if(arraylist.contains(word.charAt(j))) break;
                    arraylist.add(alphabet);
                    alphabet = word.charAt(j);                    
                }
                if(j == word.length()-1) count++; 
            }
        }
        System.out.println(count);
    }
}