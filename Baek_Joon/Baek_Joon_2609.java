import java.util.Scanner;

public class Baek_Joon_2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.println(gcd(num1,num2));
        System.out.println(lcm(num1, num2));

    }

    public static int gcd(int a, int b) {
        if(a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return a*b/gcd(a,b);
    }
}
