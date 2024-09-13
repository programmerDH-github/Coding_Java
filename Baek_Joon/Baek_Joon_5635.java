import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Baek_Joon_5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        HashMap<Integer,String> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String[] student = br.readLine().split(" ");

            String birth = student[3] + String.format(("%02d"), Integer.parseInt(student[2])) + String.format(("%02d"), Integer.parseInt(student[1]));
            map.put(Integer.parseInt(birth), student[0]);
        }

        ArrayList<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        System.out.println(map.get(keySet.get(keySet.size()-1)));
        System.out.println(map.get(keySet.get(0)));
        
    }
}
