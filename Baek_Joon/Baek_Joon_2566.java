import java.util.Scanner;

public class Baek_Joon_2566 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int max = 0;
        int row = 0;
        int column = 0;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                int value = sc.nextInt();
                if(max <= value) {
                    row = i+1;
                    column = j+1;
                    max = value;
                }
            }
        }

        System.out.println(max);
        System.out.println(row+" "+column);

    }
}
