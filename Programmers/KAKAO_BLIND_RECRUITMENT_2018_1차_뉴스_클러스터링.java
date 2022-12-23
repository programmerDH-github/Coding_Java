package Programmers;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class KAKAO_BLIND_RECRUITMENT_2018_1��_����_Ŭ�����͸� {
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
		
		// str1�� ����
		for(int i = 0; i < str1.length(); i++) {
			if(i == str1.length()-1) break;
			
			new_str = "" + str1.charAt(i) + str1.charAt(i+1);
			result = Pattern.matches(pattern, new_str);
			// �����̳� ����, Ư�� ���ڰ� ���� �ʴ� ���
			if(result) str1_list.add(new_str); 
		}
		
		// str2�� ����
		for(int i = 0; i < str2.length(); i++) {
			if(i == str2.length()-1) break;
			
			new_str = "" + str2.charAt(i) + str2.charAt(i+1);
			result = Pattern.matches(pattern, new_str);
			// �����̳� ����, Ư�� ���ڰ� ���� �ʴ� ���
			if(result) str2_list.add(new_str); 
		}
		
		// str1�� str2�� ������
		for(int i = 0; i < str1_list.size(); i++) {
			if(str2_list.contains(str1_list.get(i))) {
				// ������ ��Ұ� �ִ� ��� str2_list���� �ش� �� ����
				str2_list.remove(str1_list.get(i));
				intersection++;
			}
		}
		
		// str1�� str2�� ������
		union = str1_list.size() + str2_list.size();
		
		// �������� ���
		if(union == 0 && intersection == 0) {
			System.out.println(65536);
		}
		// �������� �ƴ� ���
		else {
			double answer = (double)intersection / (double)union;
			System.out.println((int)(answer*65536));
		}

	}

}
