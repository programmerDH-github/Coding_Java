package Test;

import java.math.BigInteger;

public class SK_ICT_Family_개발자채용_3번 {

	static int width;
	static int height;
	public static void main(String[] args) {
		int width = 51; int height = 37; int[][] diagonals = {{17,19}};
		
				
		
		for(int i = 0; i < diagonals.length; i++) {
			int x = diagonals[i][0];
			int y = diagonals[i][1];
			
			int xDot = x-1;
			int yDot = y-1;
			
			BigInteger bi = BigInteger.valueOf(factorial(xDot + y));
			BigInteger b2 = BigInteger.valueOf(factorial(width-xDot + height-y));
			System.out.println(b2);
			
			System.out.println("x : " + xDot);
			System.out.println("y : " + yDot);
			
			long firstLoot = (factorial(xDot + y) / factorial(y) * factorial(xDot)) * 
					(factorial(width-xDot + height-y) / factorial(height-y) * factorial(width-xDot));
			long secondLoot = (factorial(x + yDot) / (factorial(x)*factorial(yDot))) * 
					(factorial(width-x + height-yDot) / (factorial(width-x)*factorial(height-yDot)));
			long totalLoot = firstLoot + secondLoot;
			
			
		}
		
		
		
	}
	
	public static long factorial (int n) {
		if(n <= 1) {
			return 1;
		}
		else {
			return factorial(n-1) * n;
		}
	}

}
	/*
		가로 M개, 세로 N개의 격자로 되어 있는 직사각형의 경우에서 오른쪽으로 M, 위쪽으로 N번 이동하는 최단 경로의 수
		(M+N)! / M!N!
	*/
