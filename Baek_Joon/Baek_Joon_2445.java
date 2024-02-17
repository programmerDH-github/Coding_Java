import java.util.Scanner;

public class Baek_Joon_2445 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N*2; i++) {
            if(i == N) continue;
            for(int j = 0; j < N*2; j++) {
                if(i < N) {
                    if(i >= j || N*2-i-1 <= j) System.out.print("*");
                    else System.out.print(" ");
                }
                else {
                    if(N*2-i-1 >= j || i <= j) System.out.print("*");
                    else System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}
