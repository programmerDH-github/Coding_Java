import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] number = new String[3];
        for(int i = 0; i < 3; i++) {
            number[i] = br.readLine();
        }

        int target = 0;
        for(int i = 0; i < number.length; i++) {
            if(number[i].contains("Fizz") || number[i].contains("Buzz")) {
                target++;
            }
            else {
                target = Integer.parseInt(number[i]);
                target++;
            }

        }
        
        if(target % 3 == 0 && target % 5 == 0) System.out.println("FizzBuzz");
        else if(target % 3 == 0) System.out.println("Fizz");
        else if(target % 5 == 0) System.out.println("Buzz");
        else System.out.println(target);
        
    }
    
}
