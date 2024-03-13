import java.io.*;
import java.util.*;

public class Baek_Joon_2108 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        if(N == 1) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(n);
            System.out.println(n);
            System.out.println(n);
            System.out.println(0);
            return;
        }
        
        int sum = 0;
        int max = -4001;
        int min = 4001;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            
            if(max < numbers[i]) max = numbers[i];
            if(min > numbers[i]) min = numbers[i];
            sum += numbers[i];
            if(!map.containsKey(numbers[i])) {
                map.put(numbers[i], 1);
            }
            else {
                map.put(numbers[i], map.get(numbers[i])+1);
            }
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(map.get(o1) == map.get(o2)) return o1 - o2;
                return map.get(o2) - map.get(o1);
            }    
        });       

        Arrays.sort(numbers);


        System.out.println(Math.round(sum / (double)N));

        System.out.println(numbers[numbers.length/2]);

        if(map.get(keySet.get(0)) == map.get(keySet.get(1))) System.out.println(keySet.get(1));
        else System.out.println(keySet.get(0));

        System.out.println(max - min);        
        
    }
}
