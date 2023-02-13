package Programmers;

public class 두개_이하로_다른_비트 {

	public static void main(String[] args) {
		long[] numbers = {2,7};
		long[] answer = new long[numbers.length];
		
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] % 2 == 0) {
				answer[i] = numbers[i]+1;
			}
			else {
				String binary = Long.toBinaryString(numbers[i]);
				int idx = binary.lastIndexOf("0");
				
				if(idx == -1) {
					binary = "10" + binary.substring(1);
					answer[i] = Long.parseLong(binary,2);
				}
				else {
					binary = binary.substring(0,idx) + "10" + binary.substring(idx+2);
					answer[i] = Long.parseLong(binary,2);
				}
			}
			
		}
		
		for(int i = 0; i < answer.length; i++) System.out.println(answer[i]);
	}

}
