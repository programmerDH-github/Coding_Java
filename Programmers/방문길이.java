package Programmers;
import java.util.*;

public class 방문길이 {

	public static void main(String[] args) {
		String dirs = "ULURRDLLU";
		Set<String> set = new HashSet<>();
		
		int x = 5;
		int y = 5;
		
		for(int i = 0; i < dirs.length(); i++) {
			System.out.println("i : "+i);
			char direct = dirs.charAt(i);
			
			int nx = x-5;
			int ny = y-5;
			
			if(direct == 'R' && x+1 <= 10) {
				set.add(nx+""+ny+"->"+(nx+1)+""+ny);	
				set.add((nx+1)+""+ny+"->"+nx+""+ny);
				x++;
			}
			if(direct == 'L' && x-1 >= 0) {
				set.add(nx+""+ny+"->"+(nx-1)+""+ny);
				set.add((nx-1)+""+ny+"->"+nx+""+ny);
				x--;
			}
			if(direct == 'U' && y+1 <= 10) {
				set.add(nx+""+ny+"->"+nx+""+(ny+1));
				set.add(nx+""+(ny+1)+"->"+nx+""+ny);
				y++;
			}
			if(direct == 'D' && y-1 >= 0) {
				set.add(nx+""+ny+"->"+nx+""+(ny-1));
				set.add(nx+""+(ny-1)+"->"+nx+""+ny);
				y--;				
			}
			
		}
		
		System.out.println(set);
		System.out.println(set.size()/2);

	}

}
