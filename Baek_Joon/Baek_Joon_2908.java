import java.io.*;

public class Baek_Joon_2908 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] A_B = br.readLine().split(" ");

        String A = "";
        String B = "";

        for(int i = A_B[0].length()-1; i >= 0; i--) {
            A += A_B[0].charAt(i);
        }

        for(int i = A_B[1].length()-1; i >= 0; i--) {
            B += A_B[1].charAt(i);
        }

        if(Integer.parseInt(A) > Integer.parseInt(B)) {
            System.out.println(A);
        }
        else {
            System.out.println(B);
        }
    }    
}