import java.io.*;

public class Baek_Joon_5622 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        int time = 0;
        for(int i = 0; i < str.length(); i++) {
            int number = (int)str.charAt(i) - 65;
            
            time += number / 3 + 3;

            if(str.charAt(i) == 'S' || str.charAt(i) == 'V' || str.charAt(i) == 'Y' || str.charAt(i) == 'Z') time--;
        }
        System.out.println(time);
    }
}
