package Programmers;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class KAKAO_BLIND_RECRUITMENT_2018_1차_뉴스_클러스터링 {
	static String pattern = "^[A-Z]*$";
	static boolean result;
	static int intersection = 0;
	static int union = 0;
	static String new_str = "";
	
	public static void main(String[] args) {
		String str1 = "FRANCE";
		String str2 = "french";
		ArrayList<String> str1_list = new ArrayList<>();
		ArrayList<String> str2_list = new ArrayList<>();
		
		
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();		
		
		// str1의 집합
		for(int i = 0; i < str1.length(); i++) {
			if(i == str1.length()-1) break;
			
			new_str = "" + str1.charAt(i) + str1.charAt(i+1);
			result = Pattern.matches(pattern, new_str);
			// 공백이나 숫자, 특수 문자가 들어가지 않는 경우
			if(result) str1_list.add(new_str); 
		}
		
		// str2의 집합
		for(int i = 0; i < str2.length(); i++) {
			if(i == str2.length()-1) break;
			
			new_str = "" + str2.charAt(i) + str2.charAt(i+1);
			result = Pattern.matches(pattern, new_str);
			// 공백이나 숫자, 특수 문자가 들어가지 않는 경우
			if(result) str2_list.add(new_str); 
		}
		
		// str1과 str2의 교집합
		for(int i = 0; i < str1_list.size(); i++) {
			if(str2_list.contains(str1_list.get(i))) {
				// 교집합 요소가 있는 경우 str2_list에서 해당 값 삭제
				str2_list.remove(str1_list.get(i));
				intersection++;
			}
		}
		
		// str1과 str2의 합집합
		union = str1_list.size() + str2_list.size();
		
		// 공집합일 경우
		if(union == 0 && intersection == 0) {
			System.out.println(65536);
		}
		// 공집합이 아닐 경우
		else {
			double answer = (double)intersection / (double)union;
			System.out.println((int)(answer*65536));
		}

	}

}
