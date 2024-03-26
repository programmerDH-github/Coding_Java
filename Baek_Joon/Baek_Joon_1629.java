import java.io.*;

public class Baek_Joon_1629 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] A_B_C = br.readLine().split(" ");
        int A = Integer.parseInt(A_B_C[0]);
        int B = Integer.parseInt(A_B_C[1]);
        int C = Integer.parseInt(A_B_C[2]);        

        System.out.println(pow(A,B,C));
    }

    public static long pow(int a, int b, int mod) {
        if(b == 0) return 1;

        long n = pow(a, b/2,mod);
        if(b % 2 == 0) {
            return n*n % mod;
        }
        else {
            return (n*n % mod) * a % mod;
        }
    }
}
