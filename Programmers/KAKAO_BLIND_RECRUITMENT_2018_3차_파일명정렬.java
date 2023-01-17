package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class KAKAO_BLIND_RECRUITMENT_2018_3차_파일명정렬 {
	static class File {
		String file_name;
		String head;
		int number;

		public File(String file_name, String head, int number) {
			this.file_name = file_name;
			this.head = head;
			this.number = number;
		}
	}

	public static void main(String[] args) {
		String[] files = { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat" };

		File[] file_info = new File[files.length];
		
		for(int i = 0; i < files.length; i++) {
			String[] file_split = detach(files[i]);
			file_info[i] = new File(files[i], file_split[0],Integer.parseInt(file_split[1]));
		}

		Arrays.sort(file_info, new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				if((o1.head).equals(o2.head)) {
					return o1.number - o2.number;
				}
				else {
					return (o1.head).compareTo(o2.head);
				}
			}
		});
		
		String[] answer = new String[files.length];
		for(int i = 0; i < files.length; i++) {
			answer[i] = file_info[i].file_name;
			System.out.println(answer[i]);
		}
	}
	
	public static String[] detach(String file) {
		String[] file_name_info = new String[2];
		file_name_info[0] = "";
		file_name_info[1] = "";
		boolean check = false;

		for (int i = 0; i < file.length(); i++) {

			if (file.charAt(i) > 47 && file.charAt(i) < 58) {
				check = true;
				file_name_info[1] += file.charAt(i);
			} 
			else {
				if (check) break;
				file_name_info[0] += file.charAt(i);
			}
		}
		file_name_info[0] = file_name_info[0].toLowerCase();
		
		return file_name_info;
	}

}
