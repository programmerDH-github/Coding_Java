import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Baek_Joon_1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int recommend = Integer.parseInt(br.readLine());

        int[][] student = new int[recommend][3];
        String[] input = br.readLine().split(" ");
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int i = 0; i < recommend; i++) {
            int number = Integer.parseInt(input[i]);
            if(!map.containsKey(number)) {
                map.put(number, new int[]{1,i});
            }
            else {
                int[] numbers = {map.get(number)[0]+1,i};
                map.put(number,numbers);
            }
        }
        System.out.println(map);
        ArrayList<Integer> arraylist = new ArrayList<>();
        
        
    }
}
