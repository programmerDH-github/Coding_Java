package Programmers;

public class µ¡Ä¥ÇÏ±â {

	public static void main(String[] args) {
		int n = 8;
		int m = 4; 
		int[] section = {2,3,6};
		
		int answer = 0;
        boolean[] check = new boolean[n+1];
        for(int i = 0; i < section.length; i++) {
            check[section[i]] = true;
        }
        
        for(int i = 1; i <= n; i++) {
            if(check[i]) {
                answer++;
                for(int j = i; j < i+m; j++) {
                    if(j > n) break;                    
                    check[j] = false;
                }
            }
        }
        
        System.out.println(answer);

	}

}
