import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_9742 {
    static String[] input;
    static int target;
    static boolean[] checked;
    static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.println();
        String line;
        while((line = br.readLine()) != null) {
            input = line.split(" ");
            target = Integer.parseInt(input[1]);
            checked = new boolean[input[0].length()];
            answer = "";

            backtracking("");

            if(answer.equals("")) answer = "No permutation";        

            System.out.println(input[0]+" "+input[1]+" = "+answer);
        }
    }

    static void backtracking(String str){
        if(str.length() == input[0].length()) {
            target--;
            if(target == 0) answer = str;
            return;
        }
        
        

        for(int i = 0; i < input[0].length(); i++) {
            if(!checked[i]) { 
                checked[i] = true;
                if(target == 0) return;
                backtracking((str+input[0].charAt(i)));                
                checked[i] = false;
            }
        }
    }

}
