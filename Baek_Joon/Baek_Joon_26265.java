package Baek_Joon;
import java.io.*;
import java.util.*;

public class Baek_Joon_26265 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[][] members = new String[5][2];
		
		for(int i = 0; i < n; i++) {
			String[] member = br.readLine().split(" ");
			members[i][0] = member[0];
			members[i][1] = member[1];
		}
		
		Arrays.sort(members, new Comparator<String[]>() {
			
			@Override
			public int compare(String[] o1, String[] o2) {
				return !o1[0].equals(o2[0]) ? o1[0].compareTo(o2[0]) : o2[1].compareTo(o1[1]);
			}
			
		});
		
		for(int i = 0; i < n; i++) {
			System.out.println(members[i][0]+" "+members[i][1]);
		}
		
	}

}