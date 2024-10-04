import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_2621 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] colors = new int[4]; // R B Y G
        int[] numbers = new int[10];
        for(int i = 0; i < 5; i++) {
            String[] input = br.readLine().split(" ");

            // R
            if(input[0].equals("R")) {
                colors[0]++;
            }
            // B
            else if(input[0].equals("B")) {
                colors[1]++;
            }
            // Y
            else if(input[0].equals("Y")) {
                colors[2]++;
            }
            // G
            else {
                colors[3]++;
            }
            // System.out.println("num : "+input[1]);
            numbers[Integer.parseInt(input[1])]++;

        }
        
        Arrays.sort(numbers);

        boolean straight_check = false;
        int straight_count = 0;
        int count = 0;
        for(int i = 1; i < numbers.length; i++) {     
            System.out.println(numbers[i] + " ");       
            if(numbers[i] == 1) {
                count++;
            }
            else {
                if(straight_count < count) straight_count = count;
                count = 0;
            }

            if(i == numbers.length-1 && straight_count < count) straight_count = count;
        }


        System.out.println();
        System.out.println(straight_count);


    }
}
