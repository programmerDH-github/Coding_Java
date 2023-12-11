import java.io.*;

public class Baek_Joon_2941 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] croatia = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        
        int word_count = 0;
        for(int i = 0; i < croatia.length; i++) {
            int alphabet_size = input.length();
            input = input.replaceAll(croatia[i], "");
            
            if(croatia[i].length() == 3) {
                if(alphabet_size - input.length() == 3) {
                    word_count++;
                }
                else if(alphabet_size - input.length() > 3) {
                    word_count += (alphabet_size - input.length()) / 3;
                }
                else {
                    continue;
                }
            }
            else {
               if(alphabet_size - input.length() == 2) {
                    word_count++;
                }
                else if(alphabet_size - input.length() > 2) {
                    word_count += (alphabet_size - input.length()) / 2;
                }
                else {
                    continue;
                } 
            }
        }

        word_count += input.length();
        System.out.println(word_count);
    }
}