import java.util.Scanner;

public class Baek_Joon_4101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            int first = sc.nextInt();
            int second = sc.nextInt();

            if(first == 0 && second == 0) break;

            if(first > second) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
