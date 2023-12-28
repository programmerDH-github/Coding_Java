import java.util.Scanner;

public class Baek_Joon_11729 {
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        int N = sc.nextInt();

        sb.append((int)Math.pow(2, N)-1+"\n");

        Hanoi(N, 1, 2, 3);
        System.out.println(sb);
        
    }

    public static void Hanoi(int N, int start, int mid, int to) {
        if(N == 1) {
            sb.append(start +" "+ to +"\n");
            return;
        }

        Hanoi(N-1, start, to, mid);

        sb.append(start +" "+ to +"\n");

        Hanoi(N-1, mid, start, to);
    }
}
