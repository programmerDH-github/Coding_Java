import java.util.Scanner;

public class Baek_Joon_1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int min = Math.min(Math.abs(x-w), Math.min(x,Math.min(y, Math.abs(y-h))));
        System.out.println(min);

    }
}
