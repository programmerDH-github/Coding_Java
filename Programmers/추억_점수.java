package Programmers;

import java.util.ArrayList;

public class 추억_점수 {

	public static void main(String[] args) {
		String[] name = {"may", "kein", "kain", "radi"};
		int[] yearning = {5, 10, 1, 3};
		String[][] photo = {{"may", "kein", "kain", "radi"}
		,{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
		
		int[] answer = new int[photo.length];
		
		for(int i = 0; i < photo.length; i++) {
            ArrayList<String> arraylist = new ArrayList<>();
            for(int j = 0; j < photo[i].length; j++) {
                arraylist.add(photo[i][j]);
            }
            
            for(int j = 0; j < name.length; j++) {
                if(arraylist.contains(name[j])) {
                    answer[i] += yearning[j];
                }
            }
        }
		
		for(int i = 0; i < answer.length; i++) System.out.println(answer[i]);
		
	}

}
