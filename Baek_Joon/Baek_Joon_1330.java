package Baek_Joon;

import java.util.*;

public class Baek_Joon_1330 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        
        if(first > second) System.out.print(">");
        else if(first < second) System.out.print("<");
        else System.out.print("==");

	}

}
