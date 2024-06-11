import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Baek_Joon_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        HashMap<String,String> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String[] staff = br.readLine().split(" ");
            
            if(staff[1].equals("enter")) {
                map.put(staff[0],"enter");
            }
            else {
                map.remove(staff[0]);
            }
        }

        ArrayList<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, Collections.reverseOrder());

        for(String name : keySet) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}
