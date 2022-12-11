package Programmers;

public class Çà·ÄÀÇ°ö¼À {

	public static void main(String[] args) {
		int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
		int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
		int[][] answer = new int[arr1.length][arr2[0].length];

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2[0].length; j++) {
				for (int k = 0; k < arr1[0].length; k++) {
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}

		
		for(int i = 0; i < answer.length; i++) {
			for(int j = 0; j < answer[0].length; j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}

	}

}
