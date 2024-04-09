import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first_child_parent = br.readLine().split(" ");
        int first_child = Integer.parseInt(first_child_parent[0]);
        int first_parent = Integer.parseInt(first_child_parent[1]);

        String[] second_child_parent = br.readLine().split(" ");
        int second_child = Integer.parseInt(second_child_parent[0]);
        int second_parent = Integer.parseInt(second_child_parent[1]);

        int answer_child = first_child*second_parent + second_child*first_parent;
        int answer_parent = first_parent*second_parent;
        int divisor = gcd(answer_child, answer_parent);

        System.out.println(answer_child/divisor +" "+ answer_parent/divisor);

    }
    static int gcd(int a, int b) {
        if(a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        while(b != 0) {
            int r = a%b;
            a = b;
            b = r;
        }

        return a;
    }
}
