import java.util.*;

/**
 * Baek_Joon_2675
 */
public class Baek_Joon_1259 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String S;
        
        while(true) {
            S = input.next();            
            String answer = "yes";

            if(S.equals("0")) break;

            if(S.length() % 2 == 0) {
                int i = S.length() / 2 - 1;
                int j = S.length() / 2;

                while(true) {
                    if(i < 0 || j > S.length()-1) {
                        break;
                    }

                    if(S.charAt(i) != S.charAt(j)) {
                        answer = "no";
                        break;
                    }
                    i--;
                    j++;
                }
            }
            else {
                int i = S.length() / 2 - 1;
                int j = S.length() / 2 + 1;

                while(true) {
                    
                    if(i < 0 || j > S.length()-1) {
                        break;
                    }
                    if(S.charAt(i) != S.charAt(j)) {
                        answer = "no";
                        break;
                    }
                    i--;
                    j++;
                }
            }

            System.out.println(answer);
        }
        input.close();
    }
}