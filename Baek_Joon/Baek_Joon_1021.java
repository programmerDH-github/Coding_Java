import java.io.*;
import java.util.*;

public class Baek_Joon_1021 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        ArrayList<Integer> arraylist = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            arraylist.add(i+1);
        }

        Queue<Integer> location = new LinkedList<>();
        String[] locations = br.readLine().split(" ");
        for(int i = 0; i < locations.length; i++) {
            location.add(Integer.parseInt(locations[i]));
        }

        int answer = 0;
        while(!location.isEmpty()) {
            if(location.peek() == arraylist.get(0)) {
                location.poll();
                arraylist.remove(0);
            }
            else {
                for(int i = 0; i < arraylist.size(); i++) {
                    if(i <= arraylist.size()/2 && location.peek() == arraylist.get(i)) {
                        for(int j = 0; j < i; j++) {
                            arraylist.add(arraylist.get(0));
                            arraylist.remove(0);
                            answer++;
                        }
                        break;
                    }
                    else if(i > arraylist.size()/2 && location.peek() == arraylist.get(i)){
                        for(int j = 0; j < arraylist.size()-i; j++) {
                            arraylist.add(0,arraylist.get(arraylist.size()-1));
                            arraylist.remove(arraylist.size()-1);
                            answer++;
                        }
                        break;
                    }
                }
                               
            }
        }

        System.out.println(answer);
    }
}
