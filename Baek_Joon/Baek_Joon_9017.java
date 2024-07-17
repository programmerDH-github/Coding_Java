import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Baek_Joon_9017 {
    static HashMap<Integer, Integer> teamMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            teamMap = new HashMap<>();

            int N = Integer.parseInt(br.readLine());
            int[] game = new int[N];
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                game[j] = Integer.parseInt(input[j]);
            }

            matchingTeam(game);

            int score = 1;
            HashMap<Integer,Integer> teamScore = new HashMap<>();
            ArrayList<Integer> finish = new ArrayList<>();
            for(int j = 0; j < N; j++) {
                if(teamMap.containsKey(game[j])) {
                    if(teamMap.get(game[j]) > 2) {
                        if(!teamScore.containsKey(game[j])) teamScore.put(game[j], score);
                        else teamScore.put(game[j], teamScore.get(game[j])+score);
                        teamMap.put(game[j], teamMap.get(game[j])-1);
                        score++;
                    }
                    else if(teamMap.get(game[j]) == 2) {
                        finish.add(game[j]);
                        teamMap.put(game[j], teamMap.get(game[j])-1);
                        score++;
                    }
                    else {
                        teamMap.put(game[j], teamMap.get(game[j])-1);
                        score++;
                    }
                }
            }

            ArrayList<Integer> keySet = new ArrayList<>(teamScore.keySet());

            Collections.sort(keySet, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(teamScore.get(o1).equals(teamScore.get(o2))) {
                        return finish.indexOf(o1) - finish.indexOf(o2);
                    }
                    return teamScore.get(o1) - teamScore.get(o2);
                }
            });
            
            sb.append(keySet.get(0)).append("\n");

        }

        System.out.println(sb);

    }

    static void matchingTeam (int[] game) {
        for(int i = 0; i < game.length; i++) {
            if(!teamMap.containsKey(game[i])) teamMap.put(game[i], 1);
            else teamMap.put(game[i], teamMap.get(game[i])+1);
        }

        ArrayList<Integer> keySet = new ArrayList<>(teamMap.keySet());
        
        for(int i = 0; i < keySet.size(); i++) {
            if(teamMap.get(keySet.get(i)) != 6) teamMap.remove(keySet.get(i));
        }
        
    }

}
