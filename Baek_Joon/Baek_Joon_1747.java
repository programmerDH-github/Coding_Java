import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for(int i = N; ; i++) {
            if(isPrime(i) && isPalindrome(i)) {
                System.out.println(i);
                break;
            }
        }


    }

    static boolean isPrime(int number) {
        if(number == 1) return false;

        for(int i = 2; i < Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }

        return true;
    }

    static boolean isPalindrome(int number) {
        String num = number + "";
        
        int i = 0;
        int j = num.length()-1;
        while(i < j) {
            if(num.charAt(i) != num.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }

}
