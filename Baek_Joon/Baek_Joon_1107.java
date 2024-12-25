import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek_Joon_1107 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int M = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> arraylist = new ArrayList<>();
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            arraylist.add(Integer.parseInt(input[i]));
        }

        if(arraylist.size() == 10) {
            System.out.println(Math.abs(Integer.parseInt(target) - 100));
            return;
        }
        if(Integer.parseInt(target) == 100) {
            System.out.println(0);
            return;
        }

        ArrayList<Integer> up = new ArrayList<>();
        ArrayList<Integer> down = new ArrayList<>();

        for(int i = 0; i < target.length(); i++) {
            for(int j = 0; j <= 10; j++) {
                int newNumber = target.charAt(i) - '0' + j;
                
                if(newNumber > 9) newNumber -= 10;

                if(!arraylist.contains(newNumber)) {
                    up.add(newNumber);
                    break;
                }

            }

        }

        for(int i = 0; i < target.length(); i++) {
            for(int j = 0; j <= 10; j++) {
                int newNumber = target.charAt(i) - '0' - j;
                if(newNumber < 0) newNumber += 10;

                if(!arraylist.contains(newNumber)) {
                    down.add(newNumber);
                    break;
                }

            }

        }

        int upNumber = 0;
        int downNumber = 0;

        for(int i = 0; i < up.size(); i++) {
            upNumber += up.get(i) * Math.pow(10, up.size()-(i+1));
            downNumber += down.get(i) * Math.pow(10, up.size()-(i+1));
        }
        int answer = Math.min(Math.abs(upNumber-Integer.parseInt(target)),Math.abs(downNumber-Integer.parseInt(target))) + target.length();
        System.out.println(Math.min(Math.abs(100-Integer.parseInt(target)),answer));


    }
}