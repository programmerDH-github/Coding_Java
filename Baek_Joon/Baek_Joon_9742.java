import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_9742 {
    static String[] input;
    static int target;
    static boolean[] checked;
    static String answer;
    static char[] chars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.println();
        String line;
        while((line = br.readLine()) != null) {
            input = line.split(" ");
            target = Integer.parseInt(input[1]);
            checked = new boolean[input[0].length()];
            chars = new char[input[0].length()];
            answer = "";

            backtracking(0);

            if(answer.equals("")) answer = "No permutation";        

            System.out.println(input[0]+" "+input[1]+" = "+answer);
        }
    }

    static void backtracking(int count){
        if(target == 0) return;

        if(count == input[0].length()) {
            target--;
            if(target == 0) answer = new String(chars);
            return;
        }
        
        

        for(int i = 0; i < input[0].length(); i++) {
            if(!checked[i]) { 
                checked[i] = true;
                chars[count] = input[0].charAt(i);
                backtracking(count+1);
                checked[i] = false;
            }
        }

        return;

    }

}
