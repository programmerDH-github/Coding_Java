import java.io.*;

public class Baek_Joon_2920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine().replace(" ", "");

        if(number.equals("12345678")) System.out.println("ascending");
        else if(number.equals("87654321")) System.out.println("descending");
        else System.out.println("mixed");
    }    
}