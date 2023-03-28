package Programmers;

import java.util.*;

public class 로또의_최고_순위와_최저_순위 {

	public static void main(String[] args) {
		int[] lottos = { 44, 1, 0, 0, 31, 25 };
		int[] win_nums = { 31, 10, 45, 1, 6, 19 };
		int[] answer = new int[2];

		ArrayList<Integer> arraylist = new ArrayList<>();

		Arrays.sort(lottos);
		Arrays.sort(win_nums);
		
		for(int i = 0; i < win_nums.length; i++) {
            arraylist.add(win_nums[i]);
        }
		
		int zero_count = 0;
        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) zero_count++;
            else if(arraylist.contains(lottos[i])) {
                for(int j = 0; j < arraylist.size(); j++) {
                    if(lottos[i] == arraylist.get(j)) {
                        arraylist.remove(j);
                    }
                }
            }
        }
        
        if(arraylist.size()-zero_count > 4) answer[0] = 6;
        else {
            answer[0] = arraylist.size()-zero_count+1;
        }
        
        if(arraylist.size() > 4) {
            answer[1] = 6;
        }
        else {
            answer[1] = arraylist.size()+1;
        }
        
        System.out.println(answer[0] +","+ answer[1]);
	}

}
