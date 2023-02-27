package Baek_Joon;

import java.io.*;

public class Baek_Joon_11382 {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        long answer = 0;
        
        for(String number : numbers) answer += Long.parseLong(number);        
        System.out.println(answer);
    }
}
