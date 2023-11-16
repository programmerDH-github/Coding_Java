import java.io.*;

public class Baek_Joon_2884 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] H_M = br.readLine().split(" ");
        int H = Integer.parseInt(H_M[0]);
        int M = Integer.parseInt(H_M[1]);

        if(M >= 45) {
            M -= 45;
            System.out.println(H+" "+M);
        }
        else {
            if(H == 0) {
                H = 23;
                M += 60 - 45;
                
            }
            else {
                H -= 1;
                M += 60 - 45;
            }
            System.out.println(H+" "+M);
        }

    }
}
