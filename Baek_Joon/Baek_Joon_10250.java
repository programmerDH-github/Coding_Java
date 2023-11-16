import java.io.*;

public class Baek_Joon_10250 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
           
        for(int i = 0; i < T; i++) {            
            String[] H_W_N = br.readLine().split(" ");
            int H = Integer.parseInt(H_W_N[0]);
            int N = Integer.parseInt(H_W_N[2]);
            int answer = 0;            
                        
            if(N % H == 0) {
                answer += (H * 100);
                answer += N / H;
            }
            else {
                answer += (N % H * 100);
                answer += N / H + 1;
            }

            System.out.println(answer);
        }
    }
}
