import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_6588 {
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        isPrime();

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            int front = 0;
            int end = n;
            boolean check = false;
            while(end >= front) {
                if(!prime[front] && !prime[end]) {
                    if(front + end == n) {
                        sb.append(n).append(" = ").append(front).append(" + ").append(end).append("\n");
                        check = true;
                        break;
                    }
                    else if(front + end > n) {
                        end--;
                    }
                    else {
                        front++;
                    }

                }
                else if(!prime[front]) {
                    end--;
                }
                else {
                    front++;
                }

            }

            if(!check) sb.append("Goldbach's conjecture is wrong.").append("\n");

        }

        System.out.println(sb);

    }

    static void isPrime() {
        prime = new boolean[1000001];

        prime[0] = prime[1] = true;

        for(int i = 2; i*i <= 1000000; i++) {
            if(!prime[i]) {
                for(int j = i*i; j <= 1000000; j += i) prime[j] = true;
            }
        }

    }

}
