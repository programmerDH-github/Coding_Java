package Programmers;

public class 배열자르기 {
	public static void main(String[] args) {
		int n = 4;long left = 7;long right = 14;
		
		int[] answer = new int[(int)(right-left)+1];
		
		for(int i = 0; i < answer.length; i++) {
            int max = Math.max((int)((left+i)/n), (int)((left+i)%n));
            answer[i] = max+1;
		}
		
		for(int number : answer) System.out.print(number+" ");

	}
	
}
