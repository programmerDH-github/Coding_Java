package Programmers;
import java.io.*;

public class ¸Ö¸®¶Ù±â {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] answer = new int[2000+1];
        
        answer[1] = 1;
        answer[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            answer[i] = (answer[i-1] + answer[i-2])%1234567;
        }
        
        System.out.println(answer[n]);
	}

}
