package Test;

import java.math.BigInteger;

public class SK_ICT_Family_������ä��_3�� {

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
		���� M��, ���� N���� ���ڷ� �Ǿ� �ִ� ���簢���� ��쿡�� ���������� M, �������� N�� �̵��ϴ� �ִ� ����� ��
		(M+N)! / M!N!
	*/
