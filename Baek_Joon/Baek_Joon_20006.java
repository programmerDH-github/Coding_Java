import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class Baek_Joon_20006 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] p_m = br.readLine().split(" ");
        int p = Integer.parseInt(p_m[0]);
        int m = Integer.parseInt(p_m[1]);

        ArrayList<HashMap<String,Integer>> arraylist = new ArrayList<>();
        int[] room = new int[300];
        for(int i = 0; i < p; i++) {
            String[] newUser = br.readLine().split(" ");
            int newLevel = Integer.parseInt(newUser[0]);
            String newNickname = newUser[1];
            
            boolean check = false;
            for(int j = 0; j < arraylist.size(); j++) {
                if(room[j]-10 <= newLevel && room[j]+10 >= newLevel && arraylist.get(j).size() < m) {
                    arraylist.get(j).put(newNickname, newLevel);
                    check = true;
                    break;
                }
            }

            if(!check) {
                arraylist.add(new HashMap<>());
                arraylist.get(arraylist.size()-1).put(newNickname, newLevel);
                room[arraylist.size()-1] = newLevel;
            }

        }
        
        for(int i = 0; i < arraylist.size(); i++) {
            if(arraylist.get(i).size() == m) {
                sb.append("Started!").append("\n");
            }
            else {
                sb.append("Waiting!").append("\n");
            }

            ArrayList<String> keySet = new ArrayList<>(arraylist.get(i).keySet());
            Collections.sort(keySet);

            for(String key : keySet) {
                sb.append(arraylist.get(i).get(key)).append(" ").append(key).append("\n");
            }

        }
        System.out.println();
        System.out.println(sb);

    }
}
