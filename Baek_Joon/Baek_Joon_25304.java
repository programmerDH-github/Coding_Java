import java.io.*;

public class Baek_Joon_25304{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        for(int i = 0; i < N; i++) {
            String[] a_b = br.readLine().split(" ");
            int a = Integer.parseInt(a_b[0]);
            int b = Integer.parseInt(a_b[1]);
            sum += a*b;
        }

        if(X == sum) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
