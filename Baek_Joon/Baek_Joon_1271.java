package Baek_Joon;

import java.util.*;
import java.math.*;

public class Baek_Joon_1271 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        BigInteger money = sc.nextBigInteger();
        BigInteger poeple = sc.nextBigInteger();
        
        System.out.println(money.divide(poeple));
        System.out.print(money.remainder(poeple));
    }

}
