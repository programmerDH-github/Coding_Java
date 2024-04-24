import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Baek_Joon_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String alphabet = br.readLine();
        
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < alphabet.length(); i++) {
            if(!map.containsKey(alphabet.charAt(i)+"")) {
                map.put(alphabet.charAt(i)+"", 1);
            }
            else {
                map.put(alphabet.charAt(i)+"", map.get(alphabet.charAt(i)+"")+1);
            }
        }

        List<String> key = new ArrayList<>(map.keySet());
        Collections.sort(key);
        Stack<String> reverse = new Stack<>();
        String answer = "";
        int check = 0;
        for(int i = 0; i < key.size(); i++) {
            if(map.get(key.get(i))%2 == 1) {
                check++;
                if(check > 1) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }                
            }

            for(int j = 0; j < map.get(key.get(i))/2; j++) {
                answer += key.get(i);
            }

            for(int j = 0; j < map.get(key.get(i))/2; j++) {
                reverse.push(key.get(i));
            }
        }

        for(int i = 0; i < key.size(); i++) {
            if(map.get(key.get(i))%2 == 1) {
                answer += key.get(i);
            }
        }

        while(!reverse.isEmpty()) {
            answer += reverse.pop();
        }
        System.out.println(answer);
    }
}
