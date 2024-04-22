import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double grade = 0;
        double sum = 0;
        for(int i = 0; i < 20; i++) {
            String[] subject = br.readLine().split(" ");
            if(subject[2].equals("P")) continue;
            else if(subject[2].equals("A+")) grade += Double.parseDouble(subject[1]) * 4.5;
            else if(subject[2].equals("A0")) grade += Double.parseDouble(subject[1]) * 4.0;
            else if(subject[2].equals("B+")) grade += Double.parseDouble(subject[1]) * 3.5;
            else if(subject[2].equals("B0")) grade += Double.parseDouble(subject[1]) * 3.0;
            else if(subject[2].equals("C+")) grade += Double.parseDouble(subject[1]) * 2.5;
            else if(subject[2].equals("C0")) grade += Double.parseDouble(subject[1]) * 2.0;
            else if(subject[2].equals("D+")) grade += Double.parseDouble(subject[1]) * 1.5;
            else if(subject[2].equals("D0")) grade += Double.parseDouble(subject[1]) * 1.0;
            else grade += Double.parseDouble(subject[1]) * 0.0;

            sum += Double.parseDouble(subject[1]);
        }

        if(grade == 0 && sum == 0) System.out.println(String.format("%.6f", grade));
        else {
            grade /= sum;
            System.out.println(String.format("%.6f", grade));
        }
    }
}
