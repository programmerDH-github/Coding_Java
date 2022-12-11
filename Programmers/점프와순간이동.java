package Programmers;

import java.io.*;

public class 점프와순간이동 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int answer = 0;
        
        while(n > 0) {
            if(n % 2 == 0) {
               n /= 2; 
            }
            else {
                answer++;
                n--;
            }
        }
        
        System.out.println(answer);
	}

}
