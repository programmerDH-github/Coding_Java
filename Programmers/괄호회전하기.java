package Programmers;
import java.util.*;

public class 괄호회전하기 {

	public static void main(String[] args) {
		String s = "[](){}";
		int answer = 0;
		
		ArrayList<Character> arraylist = new ArrayList<>();
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			arraylist.add(s.charAt(i));
		}
		
		for(int i = 0; i < s.length(); i++) {
			
			for(int j = 0; j < arraylist.size(); j++) {
				if(arraylist.get(j) == ')') {
					if(stack.empty() || stack.pop() != '(') {
						stack.push(arraylist.get(j));
						break;
					}
				}
				else if(arraylist.get(j) == ']') {
					if(stack.empty() || stack.pop() != '[') {
						stack.push(arraylist.get(j));
						break;
					}			
				}
				else if(arraylist.get(j) == '}') {
					if(stack.empty() || stack.pop() != '{') {
						stack.push(arraylist.get(j));
						break;
					}
				}
				else {
					stack.push(arraylist.get(j));
				}
				
				
			}
			
			if(stack.empty()) {
				answer++;
			}
			else stack.clear();
			
			char temp = arraylist.get(0);
			arraylist.remove(0);
			arraylist.add(temp);
			
		}
		
		System.out.println(answer);

	}

}
