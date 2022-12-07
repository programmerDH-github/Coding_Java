package Baek_Joon;

import java.util.*;
import java.math.BigInteger;

public class Baek_Joon_2420 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        BigInteger A = sc.nextBigInteger();
        BigInteger B = sc.nextBigInteger();
        
        System.out.print(A.subtract(B).abs());

	}

}
