import java.io.*;

public class Baek_Joon_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word = br.readLine().split("-");
        
        int positive_number = 0;
        int negative_number = 0;
        for(int i = 0; i < word.length; i++) {
            String[] cal = word[i].split("\\+");
            
            int sum = 0;
            for(int j = 0; j < cal.length; j++) {
                sum += Integer.parseInt(cal[j]);
            }
            if(i == 0) {
                positive_number += sum;
            }
            else {
                negative_number += sum;
            }
        }
        
        System.out.println(positive_number - negative_number);
        
    }
}
