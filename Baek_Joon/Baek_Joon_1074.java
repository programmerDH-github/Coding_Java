import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1074 {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_r_c = br.readLine().split(" ");
        int N = Integer.parseInt(N_r_c[0]);
        int r = Integer.parseInt(N_r_c[1]);
        int c = Integer.parseInt(N_r_c[2]);
        int size = (int)Math.pow(2, N);

        find(size,r,c);
        System.out.println(count);
    }

    static void find(int size, int r, int c) {
        if(size == 1) {
            return;
        }

        if(r < size/2 && c < size/2) {
            find(size/2, r, c);
        }
        else if(r < size/2 && c >= size/2) {
            count += (size*size/4);
            find(size/2, r, c-size/2);
        }
        else if(r >= size/2 && c < size/2) {
            count += (size*size/4)*2;
            find(size/2, r-size/2, c);
        }
        else {
            count += (size*size/4)*3;
            find(size/2, r-size/2, c-size/2);
        }

    }
}
