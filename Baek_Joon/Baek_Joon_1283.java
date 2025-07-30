import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baek_Joon_1283 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");   
            int x = -1;
            int y = -1;
            
            for(int j = 0; j < input.length; j++) {
                char target = Character.toLowerCase(input[j].charAt(0));
                if(!map.containsKey(target)) {
                     map.put(target, 1);
                    x = j;
                    y = 0;
                    break;
                }
            }

            if(x != -1 && y != -1) {
                shortcutKey(x,y,input);
                continue;
            }

            for(int j = 0; j < input.length; j++) {
                for(int k = 1; k < input[j].length(); k++) {
                    char target = Character.toLowerCase(input[j].charAt(k));
                    if(x == -1 && y == -1 && !map.containsKey(target)) {
                        map.put(target, 1);
                        x = j;
                        y = k;
                        break;                        
                    }
                }
            }
            
            shortcutKey(x, y, input);

        }

        System.out.println(sb);
     
    }

    static void shortcutKey (int x, int y, String[] input) {
        for(int i = 0; i < input.length; i++) {
            if(x == i) {
                for(int j = 0; j < input[i].length(); j++) {
                    if(y == j) sb.append("[" + input[i].charAt(j) + "]");
                    else sb.append(input[i].charAt(j));
                }
            }
            else {
                sb.append(input[i]);
            }
            sb.append(" ");
        }

        sb.append("\n");

    }

}
