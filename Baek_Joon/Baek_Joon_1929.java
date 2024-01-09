import java.io.*;

public class Baek_Joon_1929 {
    static boolean[] prime;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] M_N = br.readLine().split(" ");
        int M = Integer.parseInt(M_N[0]);
        int N = Integer.parseInt(M_N[1]);

        prime = new boolean[N+1];
        isPrime(N);
        for(int i = M; i <= N; i++) {
            if(!prime[i]) sb.append(i).append('\n');
        }
        System.out.println(sb);
    }

    public static void isPrime(int N) {
        prime[0] = true;
        prime[1] = true;

        for(int i = 2; i < Math.sqrt(N); i++) {
            if(!prime[i]) {
                for(int j = i*i; j <= N; j+=i) {
                    prime[j] = true;
                }
            }
        }
    }
}
