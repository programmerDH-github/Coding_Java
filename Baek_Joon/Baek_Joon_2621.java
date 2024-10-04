import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Baek_Joon_2621 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] colors = new String[5];
        int[] numbers = new int[5];
        int colorCount = 1;
        int[] numberCount = new int[10];

        for(int i = 0; i < 5; i++) {
            String[] input = br.readLine().split(" ");

            String color = input[0];
            int number = Integer.parseInt(input[1]);

            colors[i] = color;
            numbers[i] = number;

            if(i > 0 && colors[i-1].equals(colors[i])) colorCount++;

            numberCount[number]++;
        }

        Arrays.sort(numbers);

        int straightNumber = 1;
        
        for(int i = 1; i < numbers.length; i++) {
            if(numbers[i-1]+1 == numbers[i]) straightNumber++;
        }


        int fourSameNumber = 0;
        int threeSameNumber = 0;
        int twoSameNumber = 0;
        int twoOtherSameNumber = 0;

        for(int i = 1; i < 10; i++) {
            if(numberCount[i] == 4) {
                fourSameNumber = i;
                break;
            }
            else if(numberCount[i] == 3) {
                threeSameNumber = i;
            }
            else if(numberCount[i] == 2) {
                if(twoSameNumber == 0) twoSameNumber = i;
                else twoOtherSameNumber = i;
            
            }
        }

        if(straightNumber == 5 && colorCount == 5) {
            System.out.println(numbers[4] + 900);
        }
        else if(fourSameNumber != 0) {
            System.out.println(fourSameNumber + 800);
        }
        else if(threeSameNumber != 0 && twoSameNumber != 0) {
            System.out.println(threeSameNumber*10 + twoSameNumber + 700);
        }
        else if(colorCount == 5) {
            System.out.println(numbers[4] + 600);
        }
        else if(straightNumber == 5) {
            System.out.println(numbers[4] + 500);
        }
        else if(threeSameNumber != 0 && twoSameNumber == 0) {
            System.out.println(threeSameNumber + 400);
        }
        else if(twoSameNumber != 0 && twoOtherSameNumber != 0) {
            int bigNumber = twoSameNumber;
            int smallNumber = twoOtherSameNumber;
            if(twoSameNumber < twoOtherSameNumber)  {
                bigNumber = twoOtherSameNumber;
                smallNumber = twoSameNumber;
            }

            System.out.println(bigNumber*10 + smallNumber + 300);
        }
        else if(twoSameNumber != 0) {
            System.out.println(twoSameNumber + 200);
        }
        else {
            System.out.println(numbers[4] + 100);
        }

    }
}

