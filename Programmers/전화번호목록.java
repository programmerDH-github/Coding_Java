package Programmers;
import java.util.Arrays;

public class 전화번호목록 {

	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		Arrays.sort(phone_book);
        
        int i = 0;
        int j = i+1;
        while(true) {
            if(i >= phone_book.length && j >= phone_book.length) break;
            else if(i < phone_book.length && j >= phone_book.length) {
                i++;
                j = i+1;
            }
            else {
                if(phone_book[j].contains(phone_book[i]) 
                   && phone_book[j].indexOf(phone_book[i]) == 0) {
                	System.out.println(false);
                	return;
                }
                if(phone_book[i].contains(phone_book[j]) 
                   && phone_book[i].indexOf(phone_book[j]) == 0) {
                	System.out.println(false);
                	return;
                }
                i++;
                j++;
            }
            
        }
		
		System.out.println(true);

	}

}
