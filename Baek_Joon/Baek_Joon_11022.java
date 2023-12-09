import java.io.*;

public class Baek_Joon_11022 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String[] A_B = br.readLine().split(" ");
            int A = Integer.parseInt(A_B[0]);
            int B = Integer.parseInt(A_B[1]);

            System.out.println("Case #"+(i+1)+": "+A+" + "+B+" = "+(A+B));
        }
    }
}