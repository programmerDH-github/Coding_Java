package Test;

public class Line_test2 {
	static String[] chatArr;
	public static void main(String[] args) {
		int k = 2;
		String[] dic = {"slang", "badword"};
		String chat = "badword ab.cd bad.ord .word sl.. bad.word";
		
		String answer = "";
		String filter = "#";

        chatArr = chat.split(" ");

        for(int i = 0; i < dic.length; i++) {
            for(int j = 0; j < chatArr.length; j++) {
            	if(dic[i].length() >= chatArr[j].length()) {
            		System.out.println("dic : " + dic[i]);
                	System.out.println("chatArr : " + chatArr[j]);
                	
                	if(dic[i].equals(chatArr[j])) {
                		chatArr[j] = filter.repeat(chatArr[j].length());
                	}
                	
            	}
            	
            }
        }
        
        for(String s : chatArr) {
        	System.out.print(s + " ");
        }

	}

}
