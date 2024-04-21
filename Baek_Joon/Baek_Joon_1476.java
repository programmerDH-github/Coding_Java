import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] E_S_M = br.readLine().split(" ");
        int E = Integer.parseInt(E_S_M[0]);
        int S = Integer.parseInt(E_S_M[1]);
        int M = Integer.parseInt(E_S_M[2]);

        int year = 1;
        int e = 1,s = 1,m = 1;
        while(true) {

            if(e == 16) e = 1;
            if(s == 29) s = 1;
            if(m == 20) m = 1;
            
            if(e == E && s == S && m == M) {
                System.out.println(year);
                break;
            }
            year++;
            e++; s++; m++;
        }
    }
}
