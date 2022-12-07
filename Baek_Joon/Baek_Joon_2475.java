package Baek_Joon;

import java.util.Scanner;

public class Baek_Joon_2475 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        
        int sum = 0;
        for(int i = 0; i < 5; i++) {
            int num = in.nextInt();
            sum += num*num;
        }
        
        System.out.println(sum%10);
		
	}

}
