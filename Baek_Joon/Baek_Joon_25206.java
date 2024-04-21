import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double grade = 0;
        for(int i = 0; i < 20; i++) {
            String[] subject = br.readLine().split(" ");
            if(subject[2].equals("P") || subject[2].equals("F")) continue;
            grade += Double.parseDouble(subject[1]);
        }

        grade /= (double)20;
        System.out.println(grade);
    }
}
