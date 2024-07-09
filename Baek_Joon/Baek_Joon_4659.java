import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String consonant = "bcdfghjklmnpqrstvwxyz";
        String vowel = "aeiou";
        while(true) {
            String password = br.readLine();
            if(password.equals("end")) break;

            String valid = "<"+password+"> is acceptable.";

            if(!password.contains("a") && !password.contains("e") && !password.contains("i") 
            && !password.contains("o") && !password.contains("u")) {
                sb.append("<"+password+"> is not acceptable.").append("\n");
                continue;
            }
            
            for(int i = 0; i < password.length()-2; i++) {
                if(vowel.contains(password.charAt(i)+"") && vowel.contains(password.charAt(i+1)+"") 
                && vowel.contains(password.charAt(i+2)+"") ) {
                    valid = "<"+password+"> is not acceptable.";
                    break;
                }
                
                if(consonant.contains(password.charAt(i)+"") && consonant.contains(password.charAt(i+1)+"") 
                && consonant.contains(password.charAt(i+2)+"") ) {
                    valid = "<"+password+"> is not acceptable.";
                    break;
                }
            }

            if(valid.equals("<"+password+"> is not acceptable.")) {
                sb.append(valid).append("\n");
                continue;
            }

            for(int i = 0; i < password.length()-1; i++) {
                if(password.charAt(i) == password.charAt(i+1)) {
                    if(password.charAt(i) != 'e' && password.charAt(i) != 'o') valid = "<"+password+"> is not acceptable.";
                    break;
                }
            }
            
            sb.append(valid).append("\n");
        }

        System.out.println(sb);

    }
}
